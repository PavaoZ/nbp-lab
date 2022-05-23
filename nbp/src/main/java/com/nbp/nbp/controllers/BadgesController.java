package com.nbp.nbp.controllers;

import com.nbp.nbp.models.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BadgesController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/badges")
	public List<Badge> get() {
		return jdbcTemplate.query("SELECT * from badges", BeanPropertyRowMapper.newInstance(Badge.class));
	}
	
	@GetMapping("/badges/{id}")
	public Badge getOne(@PathVariable("id") long id) {
		Badge foundBadge = jdbcTemplate.queryForObject("SELECT * FROM badges WHERE id=?", BeanPropertyRowMapper.newInstance(Badge.class), id);
		return foundBadge;
	}
	
	@PutMapping("/badges/{id}")
	public String update(@PathVariable("id") long id, @RequestBody Badge badge) {
		Badge badgeToUpdate = jdbcTemplate.queryForObject("SELECT * FROM badges WHERE id=?", BeanPropertyRowMapper.newInstance(Badge.class), id);
		
		if(badgeToUpdate != null) {
			jdbcTemplate.update("UPDATE badges SET NAME=?, USERID=?, DATES=? WHERE id=?",
			        new Object[] { 
		        		badge.getName(),
		        		badge.getUserId(),
						badge.getDates(),
		        		id 
		        	});
			
			return "SUCCESS";
		} else {
			return "NOT SUCCESSFUL";
		}
	}
	
	@PostMapping("/badges")
	public String create(@RequestBody Badge badge) {
		jdbcTemplate.update("INSERT INTO badges (NAME, USERID, DATES) VALUES(?,?,?)",
				new Object[] {
						badge.getName(),
						badge.getUserId(),
						badge.getDates()
				});
		
		return "SUCCESS";
	}
	
	@DeleteMapping("/badges/{id}")
	public int delete(@PathVariable("id") long id) {
		return jdbcTemplate.update("DELETE FROM badges WHERE id=?", id);
	}
}
