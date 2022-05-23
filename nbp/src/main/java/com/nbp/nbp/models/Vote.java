package com.nbp.nbp.models;

import java.sql.Date;

public class Vote {
	private Integer id;
	private Integer postId;
	private Integer userId;
	private Integer bountyAmount;
	private Integer voteTypeId;
	private Date creationDate;

	public Vote() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Integer getBountyAmount() {
		return bountyAmount;
	}
	public void setBountyAmount(Integer bountyAmount) {
		this.bountyAmount = bountyAmount;
	}
	public Integer getVoteTypeId() { return voteTypeId; }
	public void setVoteTypeId(Integer voteTypeId) { this.voteTypeId = voteTypeId; }
	public Date getCreationDate() { return creationDate; }
	public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }
}