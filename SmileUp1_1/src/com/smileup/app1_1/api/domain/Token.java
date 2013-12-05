package com.smileup.app1_1.api.domain;

public class Token {
	private String useId;
	private String session;
	private String token;

	public String getUseId() {
		return useId;
	}

	public void setUseId(String useId) {
		this.useId = useId;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public class TokenFunctions {

		public static final String CreateUser = "create_user";
		public static final String LoginUser = "login_user";
		public static final String LogoutUser = "logout_user";
		public static final String LogUsage = "log_usage";
		public static final String GetApiList = "get_api_list";
	}

}
