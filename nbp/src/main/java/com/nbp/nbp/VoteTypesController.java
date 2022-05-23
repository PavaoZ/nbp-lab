package com.nbp.nbp.controllers;

import com.nbp.nbp.models.VoteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoteTypesController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/vote-types")
	public List<VoteType> get() {
		return jdbcTemplate.query("SELECT * from votetypes", BeanPropertyRowMapper.newInstance(VoteType.class));
	}
	
	@GetMapping("/vote-types/{id}")
	public VoteType getOne(@PathVariable("id") long id) {
		VoteType foundVoteType = jdbcTemplate.queryForObject("SELECT * FROM votetypes WHERE id=?", BeanPropertyRowMapper.newInstance(VoteType.class), id);
		return foundVoteType;
	}
	
	@PutMapping("/vote-types/{id}")
	public String update(@PathVariable("id") long id, @RequestBody VoteType voteType) {
		VoteType voteTypeToUpdate = jdbcTemplate.queryForObject("SELECT * FROM votetypes WHERE id=?", BeanPropertyRowMapper.newInstance(VoteType.class), id);
		
		if(voteTypeToUpdate != null) {
			jdbcTemplate.update("UPDATE votetypes SET NAME=? WHERE id=?",
			        new Object[] { 
		        		voteType.getName(),
		        		id 
		        	});
			
			return "SUCCESS";
		} else {
			return "NOT SUCCESSFUL";
		}
	}
	
	@PostMapping("/vote-types")
	public String create(@RequestBody VoteType voteType) {
		jdbcTemplate.update("INSERT INTO votetypes (NAME) VALUES(?)",
				new Object[] {
						voteType.getName()
				});
		
		return "SUCCESS";
	}
	
	@DeleteMapping("/vote-types/{id}")
	public int delete(@PathVariable("id") long id) {
		return jdbcTemplate.update("DELETE FROM votetypes WHERE id=?", id);
	}
}
