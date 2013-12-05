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
	// setParsingString������ÿ��JSON parser����Ҫ���еĺ�����
	public void setParsingString(String string) {
		this.parsingString = string;
	}

	public String getParsingString() {
		return this.parsingString;
	}

	// ���ǿ������������е����������������ȡ��Ҫparse��JSON����
	public JSONObject getJSONData() {
		return jsonObj;
	}

	// ==========================================================//
	/**
	 * ������������Ҫ���С�
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

	// �����ж��ǲ����������ݣ�����Ҫ��startParse֮����ܽ����жϡ���t�������Ĭ��Ч���жϣ�Ҳ����NotParsed
	public Boolean isCommonResult() {
		if (DataStatus == CommonData) {
			return true;
		} else {
			return false;
		}
	}

	// �����ж��ǲ��Ǵ������ݣ�����Ҫ��startParse֮����ܽ����жϡ���t�������Ĭ��Ч���жϣ�Ҳ����NotParsed
	public Boolean isError() {
		if (DataStatus == ErrorData) {
			return true;
		} else {
			return false;
		}

	}

	// ���ĺ���֮һ���Á��Д������ǲ��Ǵ���ġ���Ϊ��������ݻ���ͳһ�ĸ�ʽ���������������ǾͿ���ͳһ���ж��ǲ��Ǵ����
	// ���ǲ��ùܣ�������������ʲô���ӣ���Ϊ���������ݻ���ݲ�ͬ��������ز�ͬ�Ľ��������Ҫ�������и��ݲ�ͬ���������
	protected void analyzeDataType(String jsonString) {

		jsonObj = parseRawData(jsonString);

		if (jsonObj != null) {

			try {
				Object data = jsonObj.get("data");
				if (data.getClass().isAssignableFrom(Boolean.class)) {
					if ((Boolean) data == false) {
						// �����false����˵���д�����ʱ�����Ǿ�Ҫȥ����Error
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

	// �ڽ���parse֮�䣬����Ҫ��һ��Ԥ�ȵĴ������ж�data�ǲ��Ǵ����
	/**
	 * ���ݵķ��ػ���һ��ͳһ�ĸ�ʽ��
	 * 
	 * { "data": [ { "photo_id": "PHOTO_ID", "file_name": "FILENAME.EXT",
	 * "short_hash": "SHORTHASH", "longitude": null, "latitude": null,
	 * "timestamp": "2013-01-04 12:52:16" } ], "input": { "user_id": "ID" } }
	 * 
	 * ���е����ݶ�����һ��data��һ��input�� �����������ʱ��
	 * 
	 * { "data": false, "error": "1|Access Denied.", "input": false }
	 * �����һ��error����������Ҫ����������е����ݽ��з������Ӷ����ݴ�����д���
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
