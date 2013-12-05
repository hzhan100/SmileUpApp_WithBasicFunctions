package com.smileup.app1_1.api.domain;

public class Comments {

	private String userName;
	private String name;
	private String commentText;
	private String timestamp;
	private String edited;
	private String commentHash;
	private String own;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getCommentHash() {
		return commentHash;
	}

	public void setCommentHash(String commentHash) {
		this.commentHash = commentHash;
	}

	public String getOwn() {
		return own;
	}

	public void setOwn(String own) {
		this.own = own;
	}

	class CommentsFunctions {
		public static final String GetCommentPhoto = "get_comment_photo";
		public static final String AddComment = "add_comment";
		public static final String RemoveComment = "remove_comment";
	}

}
