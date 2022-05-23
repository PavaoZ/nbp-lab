package com.nbp.nbp.controllers;

import com.nbp.nbp.models.LinkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinkTypesController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/link-types")
	public List<LinkType> get() {
		return jdbcTemplate.query("SELECT * from linktypes", BeanPropertyRowMapper.newInstance(LinkType.class));
	}
	
	@GetMapping("/link-types/{id}")
	public LinkType getOne(@PathVariable("id") long id) {
		LinkType foundLinkType = jdbcTemplate.queryForObject("SELECT * FROM linktypes WHERE id=?", BeanPropertyRowMapper.newInstance(LinkType.class), id);
		return foundLinkType;
	}
	
	@PutMapping("/link-types/{id}")
	public String update(@PathVariable("id") long id, @RequestBody LinkType linkType) {
		LinkType linkTypeToUpdate = jdbcTemplate.queryForObject("SELECT * FROM linktypes WHERE id=?", BeanPropertyRowMapper.newInstance(LinkType.class), id);
		
		if(linkTypeToUpdate != null) {
			jdbcTemplate.update("UPDATE linktypes SET TYPE=? WHERE id=?",
			        new Object[] { 
		        		linkType.getType(),
		        		id 
		        	});
			
			return "SUCCESS";
		} else {
			return "NOT SUCCESSFUL";
		}
	}
	
	@PostMapping("/link-types")
	public String create(@RequestBody LinkType linkType) {
		jdbcTemplate.update("INSERT INTO linktypes (TYPE) VALUES(?)",
				new Object[] {
						linkType.getType()
				});
		
		return "SUCCESS";
	}
	
	@DeleteMapping("/link-types/{id}")
	public int delete(@PathVariable("id") long id) {
		return jdbcTemplate.update("DELETE FROM linktypes WHERE id=?", id);
	}
}
