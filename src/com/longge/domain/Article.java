package com.longge.domain;

import java.util.Date;

public class Article {
	private int id;
	private String title;
	private String content;
	private String username;
	private Date date;
	private int hadread;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHadread() {
		return hadread;
	}
	public void setHadread(int hadread) {
		this.hadread = hadread;
	}
	
	

}
