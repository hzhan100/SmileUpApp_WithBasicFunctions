package com.smileup.app1_1.api.domain;

public class Sponsors {

	private String sponsorId;
	private String name;

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	class TaglineObject {
		private String sponsorTagId;
		private String sponsorId;
		private String message;

		public String getSponsorTagId() {
			return sponsorTagId;
		}

		public void setSponsorTagId(String sponsorTagId) {
			this.sponsorTagId = sponsorTagId;
		}

		public String getSponsorId() {
			return sponsorId;
		}

		public void setSponsorId(String sponsorId) {
			this.sponsorId = sponsorId;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

	class SponsorFunctions {
		public static final String GetSponsor = "get_sponsor";
		public static final String GetSponsorList = "get_sponsor_list";
		public static final String GetSponsorTaglines = "get_sponsor_taglines";
		public static final String GetAllSponsorTaglines = "get_all_sponsor_taglines";
		public static final String GetSponsorUpdate = "get_sponsor_update";
		public static final String GetSponsorUpdateTime = "get_sponsor_update_time";
		public static final String GetSponsorTaglineUpdate = "get_sponsor_taglines_update";
		public static final String GetSponsorTaglinesUpdateTime = "get_sponsor_taglines_update_time";

	}

}
