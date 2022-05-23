package com.nbp.nbp.controllers;

import com.nbp.nbp.models.PostType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostTypesController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/post-types")
	public List<PostType> get() {
		return jdbcTemplate.query("SELECT * from posttypes", BeanPropertyRowMapper.newInstance(PostType.class));
	}
	
	@GetMapping("/post-types/{id}")
	public PostType getOne(@PathVariable("id") long id) {
		PostType foundPostType = jdbcTemplate.queryForObject("SELECT * FROM posttypes WHERE id=?", BeanPropertyRowMapper.newInstance(PostType.class), id);
		return foundPostType;
	}
	
	@PutMapping("/post-types/{id}")
	public String update(@PathVariable("id") long id, @RequestBody PostType postType) {
		PostType postTypeToUpdate = jdbcTemplate.queryForObject("SELECT * FROM posttypes WHERE id=?", BeanPropertyRowMapper.newInstance(PostType.class), id);
		
		if(postTypeToUpdate != null) {
			jdbcTemplate.update("UPDATE posttypes SET TYPE=? WHERE id=?",
			        new Object[] { 
		        		postType.getType(),
		        		id 
		        	});
			
			return "SUCCESS";
		} else {
			return "NOT SUCCESSFUL";
		}
	}
	
	@PostMapping("/post-types")
	public String create(@RequestBody PostType postType) {
		jdbcTemplate.update("INSERT INTO posttypes (TYPE) VALUES(?)",
				new Object[] {
						postType.getType()
				});
		
		return "SUCCESS";
	}
	
	@DeleteMapping("/post-types/{id}")
	public int delete(@PathVariable("id") long id) {
		return jdbcTemplate.update("DELETE FROM posttypes WHERE id=?", id);
	}
}
