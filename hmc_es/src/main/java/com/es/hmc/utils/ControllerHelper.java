package com.es.hmc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.ReflectionUtils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * controller助手，该类包含了controller类常用的一些常量以及方法
 * 
 * @author Venson Yang
 */
public final class ControllerHelper {
	// 文件类型
	public static final String CONTENT_TYPE_HTML = "text/html";
	public static final String CONTENT_TYPE_IMAGE_JPG = "image/jpeg";
	public static final String CONTENT_TYPE_IMAGE_PNG = "image/png";
	public final static String CONTENT_TYPE_STREAM = "application/octet-stream";
	public final static String CONTENT_TYPE_JSON = "application/json";
	public final static String CONTENT_TYPE_PDF = "application/pdf";
	public final static String CONTENT_TYPE_XML = "text/xml";
	public final static String CONTENT_TYPE_EXCEL = "application/excel";
	public final static String CONTENT_TYPE_EXCEL_93 = "application/vnd.ms-excel";
	public final static String CONTENT_TYPE_EXCEL_97 = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public final static String CONTENT_TYPE_WORD_93 = "application/msword";
	public final static String CONTENT_TYPE_WORD_97 = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
	// 附件下载格式
	public static final String CONTENT_DISPOSITION = "Content-Disposition";
	public static final String CONTENT_DISPOSITION_INLINE = "inline";
	public static final String CONTENT_DISPOSITION_ATTACHMENT = "attachment";
	// 上传文件路径
	public static final String ATTACHMENT_UPLOAD_PATH = "/upload/attachment";
	public static final String ATTACHMENT_ROOT_PATH = "/";
	public static final String EXCEL_UPLOAD_PATH = "/upload/excel";
	public static final String HTML_UPLOAD_PATH = "/upload/html";
	public static final String UPLOAD_PREVIEW_PATH = "/upload/preview";
	public static final String WORD_UPLOAD_PATH = "/upload/word";
	public static final String IMAGE_UPLOAD_PATH = "/upload/image";
	public static final String HEAD_IMAGE_UPLOAD_PATH = "/upload/image/headImage";

	private static final Log logger = LogFactory.getLog(ControllerHelper.class);

	/**
	 * 在国际化资源文件中获取指定键值的value值
	 * 
	 * @param key
	 *            键值
	 * @return 键对应的值
	 */
	public static String getMessage(String key) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("messages/message", getLang());
		String msg = resourceBundle.getString(key);
		if (msg != null)
			return msg;
		return null;
	}

	public static Locale getLang() {
		String lang = CookieUtil.findCookie("Lang");
		if (Locale.ENGLISH.getLanguage().equals(lang))
			return Locale.ENGLISH;
		return Locale.SIMPLIFIED_CHINESE;

	}

	public static String getUploadPath() {
		return getUploadPath(null);
	}

	/**
	 * 获取上传文件的根路径
	 * 
	 * @param path
	 *            相对路径
	 * @return 上传文件根路径
	 */
	public static String getUploadPath(String path) {
		HttpServletRequest request = ControllerContext.getRequest();
		if (path == null) {
			return request.getSession().getServletContext().getRealPath("/upload") + File.separator;
		}
		if (path == ATTACHMENT_ROOT_PATH)
			return request.getSession().getServletContext().getRealPath(path);
		else
			return request.getSession().getServletContext().getRealPath(path) + File.separator;

	}

	/**
	 * 获取带部署上下文的域名
	 * 
	 */
	public static String getDeployDomain() {
		HttpServletRequest request = ControllerContext.getRequest();
		StringBuffer url = request.getRequestURL();
		String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length())
				.append(request.getSession().getServletContext().getContextPath()).append("/").toString();
		return tempContextUrl;
	}

	public static String getBasePath() {
		HttpServletRequest request = ControllerContext.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		return basePath;
	}



	/**
	 * 获取域名
	 * 
	 */
	public static String getDomain() {
		HttpServletRequest request = ControllerContext.getRequest();
		StringBuffer url = request.getRequestURL();
		String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/")
				.toString();
		return tempContextUrl;
	}

	public static String getDownloadPath() {
		HttpServletRequest request = ControllerContext.getRequest();
		return request.getSession().getServletContext().getRealPath("/download") + File.separator;
	}

	/**
	 * 获取打印文件的根路径
	 * 
	 * @return 打印文件根路径
	 */
	public static String getPrintPath() {
		HttpServletRequest request = ControllerContext.getRequest();
		return request.getSession().getServletContext().getRealPath("/prints") + File.separator;
	}

	/**
	 * 
	 * @Title: processFileName
	 * 
	 * @Description: ie,chrom,firfox下处理文件名显示乱码
	 */
	public static String processFileName(String fileNames) {
		HttpServletRequest request = ControllerContext.getRequest();
		String codedfilename = null;
		try {
			String agent = request.getHeader("USER-AGENT");
			if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie

				String name = java.net.URLEncoder.encode(fileNames, "UTF8");

				codedfilename = name;
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等

				codedfilename = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
			}
		} catch (Exception e) {
			logger.info("ERROR", e);
		}
		return codedfilename;
	}

	/**
	 * 输入下载文件
	 * 
	 * @param contentType
	 *            文件类型
	 * @param header
	 *            文件打开形式以及文件名
	 * @param data
	 *            文件数据
	 * @return 打印文件根路径
	 */
	public static void makeAttachment(String contentType, String header[], byte[] data) throws IOException {
		HttpServletResponse response = ControllerContext.getResponse();
		response.setContentType(contentType);
		response.setHeader(CONTENT_DISPOSITION, header[0] + ";fileName=" + processFileName(header[1]));
		ServletOutputStream stream = response.getOutputStream();
		stream.write(data);
		stream.flush();
		stream.close();
	}

	public static void makeAttachment(String contentType, String[] header, InputStream data) throws IOException {
		makeAttachment(contentType, header, IOUtils.toByteArray(data));
	}

	public static void makeAttachment(String contentType, String[] header, String filePath) throws IOException {
		makeAttachment(contentType, header, IOUtils.toByteArray(new FileInputStream(filePath)));
	}

	


	public static void renderJSON(String contentType, Object obj) throws IOException {
		contentType = StringUtils.defaultString((String) contentType, CONTENT_TYPE_JSON);
		HttpServletResponse response = ControllerContext.getResponse();
		response.setContentType(contentType + "; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(JSONObject.toJSON(obj));
		out.close();
	}

	/**
	 * 生成文件名
	 * 
	 * @param ext
	 *            文件扩展名
	 */
	public static String makeFileName(String ext) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(java.util.UUID.randomUUID().toString());
		buffer.append("-");
		buffer.append(System.currentTimeMillis());
		if (ext != null) {
			buffer.append(ext);
		}
		return buffer.toString();
	}

	public static String bulidFileName() {
		return makeFileName(null);
	}

	public static <T> T getData(Class<T> vo) {
		try {
			T dataResult = vo.newInstance();
			Field[] fields = vo.getDeclaredFields();
			HttpServletRequest request = ControllerContext.getRequest();
			for (Field field : fields) {
				ReflectionUtils.makeAccessible(field);
				// String
				// paramValue=ServletActionContext.getRequest().getParameter(field.getName());
				String[] paramValueArray = request.getParameterValues(field.getName());
				if (paramValueArray != null) {
					if (field.getType().equals(String[].class)) {
						ReflectionUtils.setField(field, dataResult, paramValueArray);
					} else if (field.getType().equals(Character[].class)) {
						Character[] data = new Character[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							data[i] = paramValueArray[i].toCharArray()[0];
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(Boolean[].class)) {
						boolean[] data = new boolean[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNotBlank(paramValueArray[i])) {
								data[i] = Boolean.parseBoolean(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(boolean[].class)) {
						boolean[] data = new boolean[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNotBlank(paramValueArray[i])) {
								data[i] = Boolean.parseBoolean(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(int[].class)) {
						int[] data = new int[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = Integer.parseInt(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(float[].class)) {
						float[] data = new float[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = Float.parseFloat(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(Date[].class)) {
						Date[] data = new Date[paramValueArray.length];
						SimpleDateFormat sdf;
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.trim(paramValueArray[i]).length() > 10) {
								sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							} else {
								sdf = new SimpleDateFormat("yyyy-MM-dd");
							}
							try {
								data[i] = sdf.parse(paramValueArray[i]);
							} catch (ParseException e) {
								logger.debug(e.toString());
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(Integer[].class)) {
						Integer[] data = new Integer[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = new Integer(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(Float[].class)) {
						Float[] data = new Float[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = new Float(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(Byte[].class)) {
						Byte[] data = new Byte[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = new Byte(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(byte[].class)) {
						byte[] data = new byte[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = Byte.parseByte(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(Short[].class)) {
						Short[] data = new Short[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = new Short(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(short[].class)) {
						short[] data = new short[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = Short.parseShort(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(Long[].class)) {
						Long[] data = new Long[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = new Long(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(long[].class)) {
						long[] data = new long[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = Long.parseLong(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(Double[].class)) {
						Double[] data = new Double[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = new Double(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(double[].class)) {
						double[] data = new double[paramValueArray.length];
						for (int i = 0; i < paramValueArray.length; i++) {
							if (StringUtils.isNumeric(paramValueArray[i])) {
								data[i] = Double.parseDouble(paramValueArray[i]);
							}
						}
						ReflectionUtils.setField(field, dataResult, data);
					} else if (field.getType().equals(String.class)) {
						if (null != paramValueArray[0]) {
							ReflectionUtils.setField(field, dataResult, paramValueArray[0]);
						}
					} else if (field.getType().equals(Character.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							char[] data = paramValueArray[0].toCharArray();
							ReflectionUtils.setField(field, dataResult, data[0]);
						}
					} else if (field.getType().equals(int.class)) {
						if (StringUtils.isNumeric(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Integer.parseInt(paramValueArray[0]));
						}
					} else if (field.getType().equals(Integer.class)) {
						if (StringUtils.isNumeric(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Integer.valueOf(paramValueArray[0]));
						}
					} else if (field.getType().equals(float.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Float.parseFloat(paramValueArray[0]));
						}
					} else if (field.getType().equals(Float.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Float.valueOf(paramValueArray[0]));
						}
					} else if (field.getType().equals(Date.class)) {
						SimpleDateFormat sdf;
						if (StringUtils.trim(paramValueArray[0]).length() > 10) {
							sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						} else {
							sdf = new SimpleDateFormat("yyyy-MM-dd");
						}
						try {
							ReflectionUtils.setField(field, dataResult, sdf.parse(paramValueArray[0]));
						} catch (ParseException e) {
							logger.debug(e.toString());
						}
					} else if (field.getType().equals(Byte.class)) {
						if (StringUtils.isNumeric(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Byte.valueOf(paramValueArray[0]));
						}
					} else if (field.getType().equals(byte.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Byte.parseByte(paramValueArray[0]));
						}
					} else if (field.getType().equals(Short.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Short.valueOf(paramValueArray[0]));
						}
					} else if (field.getType().equals(short.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Short.parseShort(paramValueArray[0]));
						}
					} else if (field.getType().equals(Long.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Long.valueOf(paramValueArray[0]));
						}
					} else if (field.getType().equals(long.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Long.parseLong(paramValueArray[0]));
						}
					} else if (field.getType().equals(Double.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Double.valueOf(paramValueArray[0]));
						}
					} else if (field.getType().equals(double.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Double.parseDouble(paramValueArray[0]));
						}
					} else if (field.getType().equals(Boolean.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Boolean.valueOf(paramValueArray[0]));
						}
					} else if (field.getType().equals(boolean.class)) {
						if (StringUtils.isNotBlank(paramValueArray[0])) {
							ReflectionUtils.setField(field, dataResult, Boolean.parseBoolean(paramValueArray[0]));
						}
					}

				}
			}
			return dataResult;
		} catch (InstantiationException e) {
			logger.debug(e.toString());
		} catch (IllegalAccessException e1) {
			logger.debug(e1.toString());
		}
		return null;
	}

}
