package com.pmq.edition.model;

import javax.xml.crypto.Data;

public class Edition {
	private int id;
	private int userId;
	private String userNickname;
	private String thumbnailPath;
	private String subject;
	private String category;
	private int publishingDate;
	private String content;
	private Data createdAt;
	private Data updatedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(int publishingDate) {
		this.publishingDate = publishingDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Data getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Data createdAt) {
		this.createdAt = createdAt;
	}
	public Data getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Data updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
