package com.smileup.app1_1.api.domain;

public class InterestTags {
	private String interestId;
	private String name;
	private String timeStamp;
	private String photos;

	public String getInterestId() {
		return interestId;
	}

	public void setInterestId(String interestId) {
		this.interestId = interestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	class TagFunctions {
		public static final String GetTag = "get_tag";
		public static final String GetTagList = "get_tag_list";
		public static final String GetTagId = "find_tag_id";
	}

}
