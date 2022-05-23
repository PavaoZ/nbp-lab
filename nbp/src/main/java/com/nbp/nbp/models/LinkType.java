package com.nbp.nbp.models;

import java.sql.Date;

public class LinkType {
	private Integer id;
	private String type;

	public LinkType() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}