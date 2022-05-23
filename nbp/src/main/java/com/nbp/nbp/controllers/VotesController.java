package com.nbp.nbp.controllers;

import com.nbp.nbp.models.User;
import com.nbp.nbp.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VotesController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/votes")
	public List<Vote> get() {
		return jdbcTemplate.query("SELECT * from votes", BeanPropertyRowMapper.newInstance(Vote.class));
	}
	
	@GetMapping("/votes/{id}")
	public Vote getOne(@PathVariable("id") long id) {
		Vote foundVote = jdbcTemplate.queryForObject("SELECT * FROM votes WHERE id=?", BeanPropertyRowMapper.newInstance(Vote.class), id);
		return foundVote;
	}
	
	@PutMapping("/votes/{id}")
	public String update(@PathVariable("id") long id, @RequestBody Vote vote) {
		Vote voteToUpdate = jdbcTemplate.queryForObject("SELECT * FROM votes WHERE id=?", BeanPropertyRowMapper.newInstance(Vote.class), id);
		
		if(voteToUpdate != null) {
			jdbcTemplate.update("UPDATE votes SET POSTID=?, USERID=?, BOUNTYAMOUNT=?, VOTETYPEID=?, CREATIONDATE=? WHERE id=?",
			        new Object[] { 
		        		vote.getPostId(),
		        		vote.getUserId(),
						vote.getBountyAmount(),
						vote.getVoteTypeId(),
						vote.getCreationDate(),
		        		id 
		        	});
			
			return "SUCCESS";
		} else {
			return "NOT SUCCESSFUL";
		}
	}
	
	@PostMapping("/votes")
	public String create(@RequestBody Vote vote) {
		jdbcTemplate.update("INSERT INTO votes (POSTID, USERID, BOUNTYAMOUNT, VOTETYPEID, CREATIONDATE) VALUES(?,?,?,?,?)",
				new Object[] {
						vote.getPostId(),
						vote.getUserId(),
						vote.getBountyAmount(),
						vote.getVoteTypeId(),
						vote.getCreationDate()
				});
		
		return "SUCCESS";
	}
	
	@DeleteMapping("/votes/{id}")
	public int delete(@PathVariable("id") long id) {
		return jdbcTemplate.update("DELETE FROM votes WHERE id=?", id);
	}
}
