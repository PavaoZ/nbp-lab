package com.nbp.nbp.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nbp.nbp.models.PostLink;

@RestController
public class PostLinkController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/post-links")
	public List<PostLink> getAll() {
		return jdbcTemplate.query("SELECT * FROM postlinks", BeanPropertyRowMapper.newInstance(PostLink.class));
	}
	
	@GetMapping("/post-links/{id}")
	public PostLink getPostLink(@PathVariable("id") long id) {
		PostLink existingPostLink = jdbcTemplate.queryForObject("SELECT * FROM postlinks WHERE id=?", BeanPropertyRowMapper.newInstance(PostLink.class), id);
		return existingPostLink;
	}
	
	@PutMapping("/post-links/{id}")
	public String update(@PathVariable("id") long id, @RequestBody PostLink postLink) {
		PostLink postLinkToUpdate = jdbcTemplate.queryForObject("SELECT * FROM postlinks WHERE id=?", BeanPropertyRowMapper.newInstance(PostLink.class), id);
		
		if(postLinkToUpdate != null) {
			jdbcTemplate.update("UPDATE postlinks SET POSTID=?, RELATEDPOSTID=?, LINKTYPEID=? WHERE ID=?",
			        new Object[] { 
			        		postLink.getPostId(),
			        		postLink.getRelatedPostId(),
			        		postLink.getLinkTypeId(),
			        		id 
		        	});
			
			return "SUCCESS";
		} else {
			return "NOT SUCCESSFUL";
		}
	}
	
	@PostMapping("/post-links")
	public String create(@RequestBody PostLink postLink) {
		jdbcTemplate.update("INSERT INTO postLinks (CREATIONDATE, POSTID, RELATEDPOSTID, LINKTYPEID) VALUES(?, ?, ?, ?)",
				new Object[] {
						LocalDateTime.now(),
						postLink.getPostId(),
						postLink.getRelatedPostId(),
						postLink.getLinkTypeId()
				});
		
		return "SUCCESS";
	}
	
	@DeleteMapping("/post-links/{id}")
	public int delete(@PathVariable("id") long id) {
		return jdbcTemplate.update("DELETE FROM postlinks WHERE id=?", id);
	}
}
