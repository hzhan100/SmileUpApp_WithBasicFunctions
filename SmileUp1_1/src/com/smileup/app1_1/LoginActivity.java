package com.smileup.app1_1;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.smileup.app1_1.api.functions.LoginFunction;
import com.smileup.app1_1.api.jsonparse.LoginJSONParse;

public class LoginActivity extends SherlockActivity {

	public static final String LoginSharePrefs = "LoginPrefs";
	public static final String UserInfoSharePrefs = "UserInfoPrefs";
	public static final String UserNamePrefKey = "username";
	public static final String PasswordPrefKey = "password";
	public static final String UserIDPrefKey = "userId";
	public static final String TokenPrefKey = "token";

	// ==========================================================//
	private static final int ManualLogin = 0x01;
	private static final int AutoLogin = 0x02;
	private static final String TAG = "LoginActivity";

	// =========================================================//
	private TextView cancelText;
	private RelativeLayout loginButton;
	private TextView loginText;
	private ActionBar mActionBar;
	// ===============================================//
	private EditText userNameInputView, passwordInputView;
	private ProgressBar loadingProgressbar;

	private HandlerThread thread;
	private Handler mHandler;
	private LoginJSONParse loginJsonParse;
	// ===============================================//
	private String inputUserName = "", inputPassword = "";
	private HashMap<String, Object> result;
	private Map<String, Object> map;
	private SharedPreferences loginUserPrefs;
	private SharedPreferences userInfoPrefs;

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.activity_login);

		initThreadComponent();
		initActionBar();
		initViewComponents();

	}

	private void initThreadComponent() {
		thread = new HandlerThread("LoginActivity_login_thread");
		thread.start();

		loginJsonParse = new LoginJSONParse(this);

		mHandler = new Handler(thread.getLooper()) {

			public void handleMessage(Message msg) {

				if (LoginActivity.this.isFinishing())
					return;

				switch (msg.arg1) {

				case ManualLogin:
					manualLogin();
					break;
				case AutoLogin:
					autoLogin();
					break;
				default:
					Log.i(TAG, "something wrong on message");
					break;
				}

				loadingProgressbar.setVisibility(View.GONE);

			};
		};

	}

	// 自动登录
	private void autoLogin() {
		userInfoPrefs = getSharedPreferences(UserInfoSharePrefs,
				Context.MODE_PRIVATE);
		String username = userInfoPrefs.getString(UserNamePrefKey, null);
		String password = userInfoPrefs.getString(PasswordPrefKey, null);

		if (username != null && password != null) {

			if (isNetworkConnected(LoginActivity.this)) {
				String resultData = LoginFunction.login(username, password);
				loginJsonParse.setParsingString(resultData);
				loginJsonParse.startParse();
				map = loginJsonParse.getParseResult();

				if (!map.isEmpty()) {
					result = (HashMap<String, Object>) map;
					saveResult(result);
					// saveUserInfo(username, password, result);
				}

			}
		}
	}

	// 手動登陸
	private void manualLogin() {
		String username = userNameInputView.getText().toString();
		String password = passwordInputView.getText().toString();

		if (isNetworkConnected(LoginActivity.this)) {
			String resultData = LoginFunction.login(username, password);
			loginJsonParse.setParsingString(resultData);
			loginJsonParse.startParse();
			map = loginJsonParse.getParseResult();

			if (!map.isEmpty()) {
				result = (HashMap<String, Object>) map;
				saveResult(result);
				saveUserInfo(username, password, result);
			}

		}
	}

	/**
	 * 保存用户信息，用于自动登陆。 我们也可以使用数据库来保存用户信息。但是由于目前不要求保存多个用户信息，也不需要OAuth认证，
	 * 所以我们直接保存在SharePreference就可以了
	 */
	protected void saveUserInfo(String username, String password,
			HashMap<String, Object> result) {
		String userid = (String) result.get(LoginJSONParse.UserID);

		userInfoPrefs = getSharedPreferences(UserInfoSharePrefs,
				Context.MODE_PRIVATE);
		Editor editor = userInfoPrefs.edit();
		editor.putString(UserNamePrefKey, username);
		editor.putString(PasswordPrefKey, password);
		editor.putString(UserIDPrefKey, userid);
		editor.commit();
	}

	/**
	 * @param result
	 *            <p>
	 *            实际上我们不需要保存token信息等在sharepreference中，我们可以把这些临时数据保存在一个静态变量中，
	 *            并在Application类中实现。
	 *            </p>
	 * 
	 */
	protected void saveResult(HashMap<String, Object> result) {
		String userid = (String) result.get(LoginJSONParse.UserID);
		String token = (String) result.get(LoginJSONParse.Token);

		loginUserPrefs = getSharedPreferences(LoginSharePrefs,
				Context.MODE_PRIVATE);
		Editor editor = loginUserPrefs.edit();
		editor.putString(UserIDPrefKey, userid);
		editor.putString(TokenPrefKey, token);
		editor.commit();

	}

	private void initViewComponents() {
		userNameInputView = (EditText) findViewById(R.id.username_loginactivity);
		passwordInputView = (EditText) findViewById(R.id.password_loginactivity);

		loadingProgressbar = (ProgressBar) findViewById(R.id.progressbar_loginactivity);
		loadingProgressbar.setVisibility(View.GONE);
	}

	private void initActionBar() {

		this.mActionBar = getSupportActionBar();
		this.mActionBar.setDisplayUseLogoEnabled(false);
		this.mActionBar.setDisplayShowHomeEnabled(false);
		this.mActionBar.setDisplayHomeAsUpEnabled(false);
		this.mActionBar.setDisplayShowCustomEnabled(true);
		this.mActionBar.setCustomView(R.layout.actionbar_welcome_activities);
		this.mActionBar.setBackgroundDrawable(getResources().getDrawable(
				android.R.color.white));

		RelativeLayout localRelativeLayout = (RelativeLayout) this.mActionBar
				.getCustomView();

		this.cancelText = ((TextView) localRelativeLayout.getChildAt(0));
		this.cancelText.setClickable(true);
		this.cancelText.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {

				// 编写cancel的代码

				// Intent localIntent = new Intent(LoginActivity.this,
				// FirstActivity.class);
				// LoginActivity.this.startActivity(localIntent);
				// LoginActivity.this.finish();
			}
		});

		this.loginText = ((TextView) localRelativeLayout
				.findViewById(R.id.logintext_titlebar_welcomeactivity));
		this.loginText.setText("Log in");

		this.loginButton = ((RelativeLayout) localRelativeLayout.getChildAt(1));
		this.loginButton.setClickable(true);
		this.loginButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// 编写login的代码

				Message msg = new Message();
				msg.arg1 = ManualLogin;
				mHandler.sendMessage(msg);

				loadingProgressbar.setVisibility(View.VISIBLE);

				// Intent localIntent = new Intent(LoginActivity.this,
				// MainActivity.class);
				// LoginActivity.this.startActivity(localIntent);
				// LoginActivity.this.finish();

			}
		});
	}

	private boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}
}
