package com.nbp.nbp.models;

import java.sql.Date;

public class User {
	private Integer id;
	private String aboutMe;
	private Integer age;
	private Date creationDate;
	private String displayName;
	private Integer downVotes;
	private String emailHash;
	private Date lastAccessDate;
	private String location;
	private Integer reputation;
	private Integer upVotes;
	private Integer views;
	private String websiteUrl;
	private Integer accountId;
	
	public User() {}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAboutMe() {
		return aboutMe;
	}
	
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getEmailHash() {
		return emailHash;
	}
	
	public void setEmailHash(String emailHash) {
		this.emailHash = emailHash;
	}
	
	public Integer getDownVotes() {
		return downVotes;
	}
	
	public void setDownVotes(Integer downVotes) {
		this.downVotes = downVotes;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Date getLastAccessDate() {
		return lastAccessDate;
	}
	
	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Integer getReputation() {
		return reputation;
	}
	
	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}
	
	public Integer getUpVotes() {
		return upVotes;
	}
	
	public void setUpVotes(Integer upVotes) {
		this.upVotes = upVotes;
	}
	
	public Integer getViews() {
		return views;
	}
	
	public void setViews(Integer views) {
		this.views = views;
	}
	
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
}