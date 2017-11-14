package com.es.hmc.utils;

import java.util.Map;



import com.alibaba.fastjson.JSON;


/**
 * 文档操作
 */
public class DocumentUtils {

	private static DocumentUtils utils = new DocumentUtils();

	public static DocumentUtils getIntance() {
		return utils;
	}

	private DocumentUtils() {
	}

	

	// *******************************钉钉发送OA消息-begin************************************************
	public boolean sendMessage(String url, String type, String json, String title, String ids, String agentId) {
		return sendMessage(url, type, JSON.parseObject(json, Map.class), title, ids, agentId, null, null);
	}

	public boolean sendMessage(String url, String type, String json, String title, String ids) {
		return sendMessage(url, type, JSON.parseObject(json, Map.class), title, ids, null, null, null);
	}

	public boolean sendMessage(String url, String type, Map<?, ?> content, String title, String ids) {
		return sendMessage(url, type, content, title, ids, null, null, null);
	}




	/**
	 *
	 * 
	 * @param url
	 *            客户端点击消息时跳转到的H5地址
	 * @param type
	 *            0：用户，1：群组
	 * @param content
	 *            消息body键值对内容
	 * @param title
	 *            标题
	 * @param ids
	 *            推送用户或群组的ID，逗号分隔,
	 * @param agentId
	 *            微应用Id
	 * @param img
	 *            消息body的图片
	 * @param bodyContent
	 *            消息body的content
	 * @return
	 */
	public boolean sendMessage(String url, String type, Map<?, ?> content, String title, String ids, String agentId,
			String img, String bodyContent) {
		return true;
	}
	// *******************************钉钉发送OA消息-end************************************************

	

}
