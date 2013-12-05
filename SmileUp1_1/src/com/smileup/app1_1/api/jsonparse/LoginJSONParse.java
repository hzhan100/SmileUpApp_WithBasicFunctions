package com.smileup.app1_1.api.jsonparse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class LoginJSONParse extends AbstractJsonParser<Map<String, Object>> {

	public static final String UserID = "userID";
	public static final String Token = "token";

	private Map<String, Object> result;
	private Context context;

	public LoginJSONParse(Context context) {
		this.context = context;

	}

	@Override
	public Map<String, Object> getParseResult() {
		return result;
	}

	@Override
	protected void parseError() {
		JSONObject jsonObj = getJSONData();
		result = new HashMap<String, Object>();
		if (jsonObj != null) {
			try {
				String errorCode = jsonObj.getString("error");
				result.put("error", errorCode);

				// Tell user the error code.
				Toast.makeText(context, errorCode, Toast.LENGTH_LONG).show();

			} catch (JSONException e) {
				e.printStackTrace();
				Log.v("parseErrorResult",
						"There is error on creating json object");
			}
		} else {
			result = Collections.emptyMap();
		}

	}

	@Override
	protected void parseData() {
		JSONObject jsonObj = getJSONData();
		result = new HashMap<String, Object>();
		if (jsonObj != null) {
			try {
				String userId = jsonObj.getString("user_id");
				String token = jsonObj.getString("token");
				result.put(UserID, userId);
				result.put(Token, token);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			result = Collections.emptyMap();
		}

	}

}
