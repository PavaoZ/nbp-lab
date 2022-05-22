package com.nbp.nbp.models;

import java.sql.Date;

public class User {
	private int id;
	private String aboutMe;
	private int age;
	private Date creationDate;
	private String displayName;
	private int downVotes;
	private String emailHash;
	private Date lastAccessDate;
	private String location;
	private int reputation;
	private int upVotes;
	private int views;
	private String websiteUrl;
	private int accountId;
	
	public User() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
	
	public int getDownVotes() {
		return downVotes;
	}
	
	public void setDownVotes(int downVotes) {
		this.downVotes = downVotes;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
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
	
	public int getReputation() {
		return reputation;
	}
	
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	
	public int getUpVotes() {
		return upVotes;
	}
	
	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}
	
	public int getViews() {
		return views;
	}
	
	public void setViews(int views) {
		this.views = views;
	}
	
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}