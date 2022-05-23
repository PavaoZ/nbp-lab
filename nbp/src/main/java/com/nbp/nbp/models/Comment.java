package com.nbp.nbp.models;

import java.time.LocalDateTime;

public class Comment {
	private Long id;
	private LocalDateTime creationDate;
	private Long postId;
	private Integer score;
	private String text;
	private Long userId;
	
	public Comment() {
	}

	public Comment(Long id, LocalDateTime creationDate, Long postId, Integer score, String text, Long userId) {
		this.id = id;
		this.creationDate = creationDate;
		this.postId = postId;
		this.score = score;
		this.text = text;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
		
}