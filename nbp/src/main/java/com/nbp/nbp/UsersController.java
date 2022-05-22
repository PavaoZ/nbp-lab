package com.nbp.nbp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/users")
	public String update() {
		return "sdsd";
	}
	
	@PostMapping("/users")
	public String create() {
		return "sdsd";
	}
	
	@DeleteMapping("/users/:id")
	public String delete() {
		return "sdsd";
	}
}
