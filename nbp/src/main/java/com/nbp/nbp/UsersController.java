package com.nbp.nbp.controllers;

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

import com.nbp.nbp.models.User;

import java.util.List;

@RestController
public class UsersController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/users")
	public List<User> get() {
		return jdbcTemplate.query("SELECT * from users", BeanPropertyRowMapper.newInstance(User.class));
	}
	
	@GetMapping("/users/{id}")
	public User getOne(@PathVariable("id") long id) {
		User foundUser = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", BeanPropertyRowMapper.newInstance(User.class), id);
		return foundUser;
	}
	
	@PutMapping("/users/{id}")
	public String update(@PathVariable("id") long id, @RequestBody User user) {
		User userToUpdate = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", BeanPropertyRowMapper.newInstance(User.class), id);
		
		if(userToUpdate != null) {
			jdbcTemplate.update("UPDATE users SET ABOUTME=?, AGE=?, CREATIONDATE=?, DISPLAYNAME=?, DOWNVOTES=?, EMAILHASH=?, LASTACCESSDATE=?, LOCATION=?, REPUTATION=?, UPVOTES=?, VIEWS=?, WEBSITEURL=?, ACCOUNTID=? WHERE id=?",
			        new Object[] { 
		        		user.getAboutMe(), 
		        		user.getAge(), 
		        		user.getCreationDate(), 
		        		user.getDisplayName(),
		        		user.getDownVotes(),
		        		user.getEmailHash(),
		        		user.getLastAccessDate(),
		        		user.getLocation(),
		        		user.getReputation(),
		        		user.getUpVotes(),
		        		user.getViews(),
		        		user.getWebsiteUrl(),
		        		user.getAccountId(),
		        		id 
		        	});
			
			return "SUCCESS";
		} else {
			return "NOT SUCCESSFUL";
		}
	}
	
	@PostMapping("/users")
	public String create(@RequestBody User user) {
		jdbcTemplate.update("INSERT INTO users (ABOUTME, AGE, CREATIONDATE, DISPLAYNAME, DOWNVOTES, EMAILHASH, LASTACCESSDATE, LOCATION, REPUTATION, UPVOTES, VIEWS, WEBSITEURL, ACCOUNTID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)",
		        new Object[] { 
	        		user.getAboutMe(), 
	        		user.getAge(), 
	        		user.getCreationDate(), 
	        		user.getDisplayName(),
	        		user.getDownVotes(),
	        		user.getEmailHash(),
	        		user.getLastAccessDate(),
	        		user.getLocation(),
	        		user.getReputation(),
	        		user.getUpVotes(),
	        		user.getViews(),
	        		user.getWebsiteUrl(),
	        		user.getAccountId()
	        	});
		
		return "SUCCESS";
	}
	
	@DeleteMapping("/users/{id}")
	public int delete(@PathVariable("id") long id) {
		return jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
	}
}
