package com.smileup.app1_1.api.domain;

public class Users {

	private String UserId;
	private String UserName;
	private String Name;
	private String Pic;
	private String TimeStamp;
	private String Points;
	private String NumPhotos;
	private String NumFollowers;

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPic() {
		return Pic;
	}

	public void setPic(String pic) {
		Pic = pic;
	}

	public String getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		TimeStamp = timeStamp;
	}

	public String getPoints() {
		return Points;
	}

	public void setPoints(String points) {
		Points = points;
	}

	public String getNumPhotos() {
		return NumPhotos;
	}

	public void setNumPhotos(String numPhotos) {
		NumPhotos = numPhotos;
	}

	public String getNumFollowers() {
		return NumFollowers;
	}

	public void setNumFollowers(String numFollowers) {
		NumFollowers = numFollowers;
	}

	class UserURL {
		public static final String WebLinkToUserProfile = "http://sandbox.smileup.co/u/";
		public static final String UserPicOnAmazonS3 = "http://i.smileup.co/userpic/";
		public static final String UserPicHttpsVersion = "https://s3-us-west-2.amazonaws.com/i.smileup.co/userpic/";
	}

	class UserActions {
		public static final String GetUser = "get_user";
		public static final String GetUserList = "get_user_list";
		public static final String GetUserProfile = "get_user_profile";
		public static final String GetUserFollowing = "get_user_following";
		public static final String GetUserUnassignedPoints = "get_user_unassigned_points";
		public static final String LikePhotos = "like_photo";
		public static final String UnlikePhoto = "unlike_photo";
		public static final String SharePhoto = "share_photo";
		public static final String FollowUser = "follow_user";
		public static final String FollowLocation = "folSlow_location";
		public static final String FollowInterest = "follow_interest";
		public static final String DonatePoints = "donate_points";
		public static final String ChangeUserPassword = "change_user_password ";
		public static final String ChangeUserEmail = "change_user_email ";
		public static final String ChangeUserInfo = "change_user_info";
		public static final String ConnectFb = "connect_fb";
		public static final String DisconnectFb = "disconnect_fb";
	}

	class LableObject {
		private String labelId;
		private String label;

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

	}

}
