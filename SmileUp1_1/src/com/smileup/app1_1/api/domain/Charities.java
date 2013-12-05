package com.smileup.app1_1.api.domain;

public class Charities {

	private String charityId;
	private String name;
	private String tagline;
	private String icon;
	private String hash;
	private String description;
	private String labelId;
	private String label;
	private String points;
	private String userPoints;

	public String getCharityId() {
		return charityId;
	}

	public void setCharityId(String charityId) {
		this.charityId = charityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getUserPoints() {
		return userPoints;
	}

	public void setUserPoints(String userPoints) {
		this.userPoints = userPoints;
	}

	class CharityURLs {
		public static final String Weblink = "http://sandbox.smileup.co/np/";
		public static final String AmazonS3HTTP = "http://i.smileup.co/nonprofit/";
		public static final String AmazonS3HTTPS = "https://s3-us-west-2.amazonaws.com/i.smileup.co/nonprofit/";
	}

	class CharityFunctions {

		public static final String GetCharity = "get_charity";
		public static final String GetCharityList = "get_charity_list";
		public static final String GetCharityListByLabel = "get_charity_list_by_label";
		public static final String GetCharityLabels = "get_charity_labels";
		public static final String GetCharityUpdate = "get_charity_update";
		public static final String GetCharityUpdateTime = "get_charity_update_time";
	}
}
