package com.guestbook.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId;
	private String title;
	private String content;
	private Date createDate;
	private String canComment;
	private int pid;
	
	private String nickName;
	
	public Message() {
		super();
	}

	public Message(int userId, String title, String content, Date createDate, String canComment, int pid) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.canComment = canComment;
		this.pid = pid;
	}

	public Message(int id, int userId, String title, String content, Date createDate, String canComment, int pid) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.canComment = canComment;
		this.pid = pid;
	}

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCanComment() {
		return canComment;
	}

	public void setCanComment(String canComment) {
		this.canComment = canComment;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", createDate=" + createDate + ", canComment=" + canComment + ", pid=" + pid + "]";
	}

	
	
	
	
	
	
	
}
