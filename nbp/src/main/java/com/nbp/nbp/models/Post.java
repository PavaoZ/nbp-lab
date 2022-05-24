package com.nbp.nbp.models;

import java.sql.Date;

public class Post {
	private Integer id;
	private Integer acceptedAnswerId;
	private Integer answerCount;
	private String body;
	private Date closeDate;
	private Integer commentCount;
	private Date communityOwnedDate;
	private Date creationDate;
	private Integer favoriteCount;
	private Date lastActivityDate;
	private Date lastEditDate;
	private String lastEditorDisplayName;
	private Integer lastEditUserId;
	private Integer ownerUserId;
	private Integer parentId;
	private Integer postTypeId;
	private Integer score;
	private String tags;
	private String title;
	private Integer viewCount;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getAcceptedAnswerId() {
		return acceptedAnswerId;
	}
	
	public void setAcceptedAnswerId(Integer acceptedAnswerId) {
		this.acceptedAnswerId = acceptedAnswerId;
	}
	
	public Integer getAnswerCount() {
		return answerCount;
	}
	
	public void setAnswerCount(Integer answerCount) {
		this.answerCount = answerCount;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public Date getCloseDate() {
		return closeDate;
	}
	
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	
	public Integer getCommentCount() {
		return commentCount;
	}
	
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
	public Date getCommunityOwnedDate() {
		return communityOwnedDate;
	}
	
	public void setCommunityOwnedDate(Date communityOwnedDate) {
		this.communityOwnedDate = communityOwnedDate;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Integer getFavoriteCount() {
		return favoriteCount;
	}
	
	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	
	public Date getLastActivityDate() {
		return lastActivityDate;
	}
	
	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}
	
	public Date getLastEditDate() {
		return lastEditDate;
	}
	
	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}
	
	public String getLastEditorDisplayName() {
		return lastEditorDisplayName;
	}
	
	public void setLastEditorDisplayName(String lastEditorDisplayName) {
		this.lastEditorDisplayName = lastEditorDisplayName;
	}
	
	public Integer getLastEditUserId() {
		return lastEditUserId;
	}
	
	public void setLastEditUserId(Integer lastEditUserId) {
		this.lastEditUserId = lastEditUserId;
	}
	
	public Integer getOwnerUserId() {
		return ownerUserId;
	}
	
	public void setOwnerUserId(Integer ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public Integer getPostTypeId() {
		return postTypeId;
	}
	
	public void setPostTypeId(Integer postTypeId) {
		this.postTypeId = postTypeId;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public String getTags() {
		return tags;
	}
	
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getViewCount() {
		return viewCount;
	}
	
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	
}