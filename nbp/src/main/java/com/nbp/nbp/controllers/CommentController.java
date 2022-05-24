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

import com.nbp.nbp.models.Comment;

@RestController
public class CommentController{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/comments")
	public List<Comment> getAll() {
		return jdbcTemplate.query("SELECT * FROM comments", BeanPropertyRowMapper.newInstance(Comment.class));
	}
	
	@GetMapping("/comments/{id}")
	public Comment getComment(@PathVariable("id") long id) {
		Comment existingComment = jdbcTemplate.queryForObject("SELECT * FROM comments WHERE id=?", BeanPropertyRowMapper.newInstance(Comment.class), id);
		return existingComment;
	}
	
	@PutMapping("/comments/{id}")
	public String update(@PathVariable("id") long id, @RequestBody Comment comment) {
		Comment commentToUpdate = jdbcTemplate.queryForObject("SELECT * FROM comments WHERE id=?", BeanPropertyRowMapper.newInstance(Comment.class), id);
		
		if(commentToUpdate != null) {
			jdbcTemplate.update("UPDATE comments SET POSTID=?, SCORE=?, TEXT=?, USERID=? WHERE id=?",
			        new Object[] {  
			        	comment.getPostId(), 
			        	comment.getScore(), 
			        	comment.getText(),
			        	comment.getUserId(),
		        		id 
		        	});
			
			return "SUCCESS";
		} else {
			return "NOT SUCCESSFUL";
		}
	}
	
	@PostMapping("/comments")
	public String create(@RequestBody Comment comment) {
		jdbcTemplate.update("INSERT INTO comments (CREATIONDATE, POSTID, SCORE, TEXT, USERID) VALUES(?,?,?,?,?)",
		        new Object[] {
		        	LocalDateTime.now(), 
		        	comment.getPostId(), 
		        	comment.getScore(), 
		        	comment.getText(),
		        	comment.getUserId()
	        	});
		
		return "SUCCESS";
	}
	
	@DeleteMapping("/comments/{id}")
	public int delete(@PathVariable("id") long id) {
		return jdbcTemplate.update("DELETE FROM comments WHERE id=?", id);
	}
}
