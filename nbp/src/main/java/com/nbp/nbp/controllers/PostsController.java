package com.nbp.nbp.controllers;

import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nbp.nbp.models.Badge;
import com.nbp.nbp.models.Post;
import java.sql.Date;

@RestController
@RequestMapping("/posts")
public class PostsController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping
	public List<Post> get() {
		return jdbcTemplate.query("SELECT * from posts", BeanPropertyRowMapper.newInstance(Post.class));
	}
	
	@GetMapping("/{id}")
	public Post getOne(@PathVariable("id") long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM posts WHERE id=?", BeanPropertyRowMapper.newInstance(Post.class), id);
	}
	
	@PostMapping
	public String create(@RequestBody Post post) {
		jdbcTemplate.update("INSERT INTO posts (ACCEPTEDANSWERID, ANSWERCOUNT, BODY, CLOSEDDATE, COMMENTCOUNT, COMMUNITYOWNEDDATE, CREATIONDATE, FAVORITECOUNT, "
				+ "LASTACTIVITYDATE, LASTEDITDATE, LASTEDITORDISPLAYNAME, LASTEDITORUSERID, OWNERUSERID, PARENTID, POSTTYPEID, SCORE, TAGS, TITLE, VIEWCOUNT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				post.getAcceptedAnswerId(), post.getAnswerCount(), post.getBody(), post.getCloseDate(), post.getCommentCount(), post.getCommunityOwnedDate(), new java.sql.Date(Calendar.getInstance().getTime().getTime()), post.getFavoriteCount(), post.getLastActivityDate(), null, null, null, post.getOwnerUserId(), post.getParentId(), post.getPostTypeId(), post.getScore(), post.getTags(), post.getTitle(), post.getViewCount());
		
		return "SUCCESS";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") long id, @RequestBody Post post) {
		Post postToUpdate = jdbcTemplate.queryForObject("SELECT * FROM posts WHERE id=?", BeanPropertyRowMapper.newInstance(Post.class), id);
		
		if(postToUpdate != null) {
			jdbcTemplate.update("UPDATE posts SET ACCEPTEDANSWERID=?, ANSWERCOUNT=?, BODY=?, CLOSEDDATE=?, COMMENTCOUNT=?, COMMUNITYOWNEDDATE=?, FAVORITECOUNT=?, "
					+ "LASTACTIVITYDATE=?, LASTEDITDATE=?, LASTEDITORDISPLAYNAME=?, LASTEDITORUSERID=?, OWNERUSERID=?, PARENTID=?, POSTTYPEID=?, SCORE=?, TAGS=?, TITLE=?, VIEWCOUNT=? WHERE id=?",
					post.getAcceptedAnswerId(), post.getAnswerCount(), post.getBody(), post.getCloseDate(), post.getCommentCount(), post.getCommunityOwnedDate(), post.getFavoriteCount(), post.getLastActivityDate(), new java.sql.Date(Calendar.getInstance().getTime().getTime()), post.getLastEditorDisplayName(), post.getLastEditUserId(), post.getOwnerUserId(), post.getParentId(), post.getPostTypeId(), post.getScore(), post.getTags(), post.getTitle(), post.getViewCount(), id);
			
			return "SUCCESS";
		} else {
			return "NOT SUCCESSFUL";
		}
	}
	
	@DeleteMapping("/{id}")
	public int delete(@PathVariable("id") long id) {
		return jdbcTemplate.update("DELETE FROM posts WHERE id=?", id);
	}
}
