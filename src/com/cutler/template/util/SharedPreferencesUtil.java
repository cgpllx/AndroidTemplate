package com.cutler.template.util;

import com.cutler.template.common.Config;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 偏好文件操作类
 * @author cutler
 *
 */
public class SharedPreferencesUtil {
	
	private static SharedPreferences sharedPreferences;

	/*
	 * 获取配置文件。
	 */
	private static SharedPreferences getSharedPreferences(Context context) {
		if(sharedPreferences == null){
			sharedPreferences = context.getSharedPreferences(Config.KEY_SHARE_PRE_FILE_NAME,
					Activity.MODE_PRIVATE);
		}
		return sharedPreferences;
	}
	
	/**
	 * 保存String型的参数。
	 * 
	 * @param key
	 * @param params
	 */
	public static synchronized void putParams(Context context, String key, String paramValue) {
		SharedPreferences spf = getSharedPreferences(context);
		spf.edit().putString(key, paramValue).commit();
	}

	/**
	 * 保存long型的参数。
	 * 
	 * @param key
	 * @param params
	 */
	public static synchronized void putParams(Context context, String key, long paramValue) {
		SharedPreferences spf = getSharedPreferences(context);
		spf.edit().putLong(key, paramValue).commit();
	}

	/**
	 * 保存boolean型的参数。
	 * 
	 * @param key
	 * @param params
	 */
	public static synchronized void putParams(Context context, String key, boolean paramValue) {
		SharedPreferences spf = getSharedPreferences(context);
		spf.edit().putBoolean(key, paramValue).commit();
	}
	
	/**
	 * 获取long类型参数
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static synchronized long getParams(Context context, String key, long defValue) {
		long longValue = defValue;
		SharedPreferences spf = getSharedPreferences(context);
		longValue = spf.getLong(key, defValue);
		return longValue;
	}
	
	/**
	 * 获取String型的参数。
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static synchronized String getParams(Context context, String key, String defValue) {
		String stringValue = defValue;
		SharedPreferences spf = getSharedPreferences(context);
		stringValue = spf.getString(key, defValue);
		return stringValue;
	}

	/**
	 * 获取Boolean型的参数。
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static synchronized boolean getParams(Context context, String key,
			boolean defValue) {
		boolean booleanValue = defValue;
		SharedPreferences spf = getSharedPreferences(context);
		booleanValue = spf.getBoolean(key, defValue);
		return booleanValue;
	}
	
	/**
	 * 删除指定的参数。
	 * 
	 * @param context
	 * @param key
	 */
	public static void removeParam(Context context, String key) {
		SharedPreferences spf = getSharedPreferences(context);
		spf.edit().remove(key).commit();
	}

}