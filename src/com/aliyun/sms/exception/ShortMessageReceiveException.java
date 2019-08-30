package com.aliyun.sms.exception;

/**
 * 短信回执异常
 * @author 苏行利
 * @date 2019-08-28 16:16:38
 */
public class ShortMessageReceiveException extends Exception {
	private static final long serialVersionUID = 2367578012739651067L;
	private String code = "-1"; // 异常编码

	/**
	 * 构造方法
	 * @author 苏行利
	 * @param message 异常信息
	 * @date 2019-08-28 16:18:12
	 */
	public ShortMessageReceiveException(String message) {
		super(message);
	}

	/**
	 * 构造方法
	 * @author 苏行利
	 * @param code 异常编码
	 * @param message 异常信息
	 * @date 2019-08-28 16:18:22
	 */
	public ShortMessageReceiveException(String code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * 构造方法
	 * @author 苏行利
	 * @param code 异常编码
	 * @param message 异常信息
	 * @param e 异常源
	 * @date 2019-08-28 16:18:32
	 */
	public ShortMessageReceiveException(String code, String message, Throwable e) {
		super(message, e);
		this.code = code;
	}

	/**
	 * 获取异常编码
	 * @author 苏行利
	 * @return 异常编码
	 * @date 2019-08-28 16:18:46
	 */
	public String getCode() {
		return code;
	}

}
