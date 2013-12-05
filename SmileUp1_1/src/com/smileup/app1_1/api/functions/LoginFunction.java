package com.smileup.app1_1.api.functions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.util.Log;

import com.smileup.app1_1.api.APIBase;
import com.smileup.app1_1.api.APITools;
import com.smileup.app1_1.api.domain.Token.TokenFunctions;

public class LoginFunction {
	// parameters are necessary for login
	public static final String PARAM_USERNAME = "email_or_username";
	public static final String PARAM_PASSWORD = "password";
	public static final String PARAM_KEY = "key";
	public static final String PARAM_SECRET = "secret";

	private static final String KEY = APIBase.KEY;
	private static final String SECRET = APIBase.SECRET;


	public static String login(String username, String password) {

		ArrayList<NameValuePair> params = setParametersForLogin(username,
				password);
		HttpEntity entity = newHttpEnitity(params);
		HttpPost post = setHttpPost(entity);
		String downloadedData=execute(post);
		
		return downloadedData;
	}

	private static ArrayList<NameValuePair> setParametersForLogin(
			String username, String password) {
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(PARAM_USERNAME, username));
		params.add(new BasicNameValuePair(PARAM_PASSWORD, password));
		params.add(new BasicNameValuePair(PARAM_KEY, KEY));
		params.add(new BasicNameValuePair(PARAM_SECRET, SECRET));
		return params;
	}

	private static HttpEntity newHttpEnitity(ArrayList<NameValuePair> params) {

		HttpEntity entity;
		try {
			entity = new UrlEncodedFormEntity(params);
		} catch (final UnsupportedEncodingException e) {
			// this should never happen.
			throw new IllegalStateException(e);
		}
		return entity;
	}

	private static HttpPost setHttpPost(HttpEntity entity) {
		HttpPost post = new HttpPost(
				APITools.assmbleAPIFunctions(TokenFunctions.LoginUser));
		post.addHeader(entity.getContentType());
		post.setEntity(entity);

		return post;
	}
	
	private static String execute(HttpPost post){
		
		HttpResponse resp;
		String response;
		
		try {
			resp = APITools.getHttpClient().execute(post);

			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

				response = EntityUtils.toString(resp.getEntity());

				Log.v("NewWorkUtilities", response);

				return response;
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
