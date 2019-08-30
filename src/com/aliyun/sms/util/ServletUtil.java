package com.aliyun.sms.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

/**
 * Servlet工具类
 * @author 苏行利
 * @date 2019-08-28 16:19:17
 */
public class ServletUtil {
	private static final String encode = "UTF-8"; // 字符编码

	/**
	 * 获取请求内容
	 * @author 苏行利
	 * @param request 请求体
	 * @return 请求内容
	 * @throws IOException
	 * @date 2019-08-28 16:19:33
	 */
	public static String getRequestContent(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding(encode);
		InputStream _in = request.getInputStream();
		ByteArrayOutputStream _out = new ByteArrayOutputStream();
		byte[] bytes = new byte[1024];
		int len;
		while ((len = _in.read(bytes)) != -1) {
			_out.write(bytes, 0, len);
		}
		_out.close();
		_in.close();
		return new String(_out.toByteArray());
	}

}
