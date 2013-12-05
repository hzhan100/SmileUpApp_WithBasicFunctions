package com.smileup.app1_1.api.jsonparse;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public abstract class AbstractJsonParser<T> {

	private String parsingString = "";

	public static final int NotParsed = 0x00;
	public static final int CommonData = 0x01;
	public static final int ErrorData = 0x02;

	private static final String TAG = "AbstractJsonParse";

	private int DataStatus = NotParsed;
	private JSONObject jsonObj = null;

	public abstract T getParseResult();

	protected abstract void parseError();

	protected abstract void parseData();

	// ==========================================================//
	// setParsingString函数是每个JSON parser必须要运行的函数。
	public void setParsingString(String string) {
		this.parsingString = string;
	}

	public String getParsingString() {
		return this.parsingString;
	}

	// 我们可以在其子类中调用这个函数，来获取需要parse的JSON对象
	public JSONObject getJSONData() {
		return jsonObj;
	}

	// ==========================================================//
	/**
	 * 主函数，必须要运行。
	 */
	public void startParse() {

		if (!isEmptyString(parsingString)) {
			analyzeDataType(parsingString);

			if (DataStatus == CommonData) {
				parseData();
			} else if (DataStatus == ErrorData) {
				parseError();
			} else {
				Log.i(TAG, String.valueOf(DataStatus));
			}
		}
	}

	// 用来判断是不是正常数据，必须要在startParse之后才能进行判断。否則，会根据默认效果判断，也就是NotParsed
	public Boolean isCommonResult() {
		if (DataStatus == CommonData) {
			return true;
		} else {
			return false;
		}
	}

	// 用来判断是不是错误数据，必须要在startParse之后才能进行判断。否則，会根据默认效果判断，也就是NotParsed
	public Boolean isError() {
		if (DataStatus == ErrorData) {
			return true;
		} else {
			return false;
		}

	}

	// 核心函數之一，用來判斷數據是不是错误的。因为错误的数据会用统一的格式返回来，这样我们就可以统一的判断是不是错误的
	// 我们不用管，正常的数据是什么样子，因为正常的数据会根据不同的情况返回不同的结果。我们要在子类中根据不同情况来处理。
	protected void analyzeDataType(String jsonString) {

		jsonObj = parseRawData(jsonString);

		if (jsonObj != null) {

			try {
				Object data = jsonObj.get("data");
				if (data.getClass().isAssignableFrom(Boolean.class)) {
					if ((Boolean) data == false) {
						// 如果是false，则说明有错误，这时候我们就要去分析Error
						DataStatus = ErrorData;
						return;
					}
				} else {
					DataStatus = CommonData;
					return;
				}
			} catch (JSONException e) {
				DataStatus = NotParsed;
				e.printStackTrace();
			}
		}

		DataStatus = NotParsed;
		return;

	}

	private Boolean isEmptyString(String string) {
		if (string != null && !"".equals(string)) {
			return false;
		} else {
			return true;
		}
	}

	// 在进行parse之间，我们要做一个预先的处理，来判断data是不是错误的
	/**
	 * 数据的返回会有一个统一的格式：
	 * 
	 * { "data": [ { "photo_id": "PHOTO_ID", "file_name": "FILENAME.EXT",
	 * "short_hash": "SHORTHASH", "longitude": null, "latitude": null,
	 * "timestamp": "2013-01-04 12:52:16" } ], "input": { "user_id": "ID" } }
	 * 
	 * 所有的数据都会有一个data和一个input。 当发生错误的时候：
	 * 
	 * { "data": false, "error": "1|Access Denied.", "input": false }
	 * 会出现一个error对象，我们需要对这个对象中的数据进行分析，从而根据错误进行处理
	 * 
	 */
	private JSONObject parseRawData(String objectString) {
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject(objectString);
			return jsonObj;

		} catch (JSONException e) {
			e.printStackTrace();
			Log.v("parseRawResult", "There is error on creating json object");
		}
		return null;
	}
}
