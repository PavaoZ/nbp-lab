package com.nbp.nbp.models;

import java.time.LocalDateTime;

public class PostLink {
	private Long id;
	private LocalDateTime creationDate;
	private Long postId;
	private Long relatedPostId;
	private Long linkTypeId;
	
	public PostLink() {
	}

	public PostLink(Long id, LocalDateTime creationDate, Long postId, Long relatedPostId, Long linkTypeId) {
		this.id = id;
		this.creationDate = creationDate;
		this.postId = postId;
		this.relatedPostId = relatedPostId;
		this.linkTypeId = linkTypeId;
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

	public Long getRelatedPostId() {
		return relatedPostId;
	}

	public void setRelatedPostId(Long relatedPostId) {
		this.relatedPostId = relatedPostId;
	}

	public Long getLinkTypeId() {
		return linkTypeId;
	}

	public void setLinkTypeId(Long linkTypeId) {
		this.linkTypeId = linkTypeId;
	}
	
}
