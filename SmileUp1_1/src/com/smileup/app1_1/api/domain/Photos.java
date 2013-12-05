package com.smileup.app1_1.api.domain;

public class Photos {
	private String photoId;
	private String shortHash;
	private String fileName;
	private String userId;
	private String caption;
	private String timestamp;
	private String locationId;
	private String charityId;
	private String sponsorId;
	private String latitude;
	private String longitude;
	private String likes;
	private String extLikes;
	private String tags;
	private String comments;
	private String numComments;
	private String donations;
	private String shares;
	private String username;
	private String name;
	private String userpic;

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getShortHash() {
		return shortHash;
	}

	public void setShortHash(String shortHash) {
		this.shortHash = shortHash;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getCharityId() {
		return charityId;
	}

	public void setCharityId(String charityId) {
		this.charityId = charityId;
	}

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getExtLikes() {
		return extLikes;
	}

	public void setExtLikes(String extLikes) {
		this.extLikes = extLikes;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getNumComments() {
		return numComments;
	}

	public void setNumComments(String numComments) {
		this.numComments = numComments;
	}

	public String getDonations() {
		return donations;
	}

	public void setDonations(String donations) {
		this.donations = donations;
	}

	public String getShares() {
		return shares;
	}

	public void setShares(String shares) {
		this.shares = shares;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserpic() {
		return userpic;
	}

	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}

	class PhotoURLs {
		public static final String Weblink = "http://sandbox.smileup.co/pic/";
		public static final String AmazonS3_HTTP = "http://i.smileup.co/c/";
		public static final String AmazonS3_HTTPS_SSL_Guideline = "https://s3-us-west-2.amazonaws.com/i.smileup.co/c/";
		public static final String AmazonS3_Return_Image = "https://s3-us-west-2.amazonaws.com/i.smileup.co/o/";
		public static final String Photo_Dynamically_Caching = "http://sandbox.smileup.co/pic/data/";
	}

	class PhotoFunctions {
		public static final String GetPhoto = "get_photo";
		public static final String GetPhotoFeed = "get_photo_feed";
		public static final String GetPhotoUser = "get_photo_user";
		public static final String GetPhotoLocation = "get_photo_location";
		public static final String GetPhotoCharity = "get_photo_charity";
		public static final String UploadPhoto = "upload_photo";
		public static final String AddPhotoCaption = "add_photo_caption";
		public static final String AddPhotoTags = "add_photo_tags";
		public static final String AddPhotoLocation = "add_photo_location";
		public static final String AddPhotoVenue = "add_photo_venue";
		public static final String AddPhotoCharity = "add_photo_charity";
		public static final String RemovePhotoCharity = "remove_photo_charity";
		public static final String GetNumUserPhotos = "get_num_user_photos";
	}

}
