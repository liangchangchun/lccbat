package com.es.hmc.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by venson on 2017/01/12.
 */
public class SMSUtil {

	public static Map<String, Date> MAP = new HashMap<String, Date>();

	private SMSUtil() {
	}

	/**
	 * 日志对象
	 */
	private static Log logger = LogFactory.getLog(SMSUtil.class);

	

	static class ClearSMS {
		private static Set<String> Store = new HashSet<>();
		private String id;

		public ClearSMS(String id) {
			this.id = id;
		}

		public void clear() {
			if (!Store.contains(id)) {
				Store.add(id);
				new Thread(() -> {
					try {
						Thread.sleep(1000 * 60 * 10);
					} catch (InterruptedException e) {
					}
					SMSUtil.MAP.remove(id);
					Store.remove(id);
				}).start();
			}
		}
	}

	/***
	 * 随机生成6位验证码
	 * 
	 * @param phone
	 *            手机号
	 * @return
	 */
	public static String createRandomVcode() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			builder.append((int) (Math.random() * 9));
		}
		String result = builder.toString();
		return result;
	}

	public static void main(String[] args) {
		System.out.println(EncryptUtils.decript("66acb3e05a08bc624d2a810a7225e563f5c347db403518a7397a7c6f31077b4e"));
	}

}
