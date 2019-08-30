package com.aliyun.sms.bean;

import java.util.Date;

/**
 * 短信回执
 * @author 苏行利
 * @date 2019-08-28 11:39:21
 */
public class ShortMessageReceive {
	private String phone_number; // 手机号码
	private String biz_id; // 发送序列号
	private String out_id; // 用户序列号
	private Integer sms_size; // 短信长度
	private boolean success; // 是否接收成功
	private String code; // 状态报告编码
	private String msg; // 状态报告说明
	private Date send_time; // 发送时间
	private Date report_time; // 状态报告时间

	/**
	 * 获取手机号码
	 * @author 苏行利
	 * @return 手机号码
	 * @date 2019-08-28 16:10:29
	 */
	public String getPhone_number() {
		return phone_number;
	}

	/**
	 * 设置手机号码
	 * @author 苏行利
	 * @param phone_number 手机号码
	 * @date 2019-08-28 16:10:35
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * 获取发送序列号
	 * @author 苏行利
	 * @return 发送序列号
	 * @date 2019-08-28 16:10:48
	 */
	public String getBiz_id() {
		return biz_id;
	}

	/**
	 * 设置发送序列号
	 * @author 苏行利
	 * @param biz_id 发送序列号
	 * @date 2019-08-28 16:10:52
	 */
	public void setBiz_id(String biz_id) {
		this.biz_id = biz_id;
	}

	/**
	 * 获取用户序列号
	 * @author 苏行利
	 * @return 用户序列号
	 * @date 2019-08-28 16:11:03
	 */
	public String getOut_id() {
		return out_id;
	}

	/**
	 * 设置用户序列号
	 * @author 苏行利
	 * @param out_id 用户序列号
	 * @date 2019-08-28 16:11:09
	 */
	public void setOut_id(String out_id) {
		this.out_id = out_id;
	}

	/**
	 * 获取短信长度
	 * @author 苏行利
	 * @return 短信长度
	 * @date 2019-08-28 16:11:42
	 */
	public Integer getSms_size() {
		return sms_size;
	}

	/**
	 * 设置短信长度
	 * @author 苏行利
	 * @param sms_size 短信长度
	 * @date 2019-08-28 16:11:46
	 */
	public void setSms_size(Integer sms_size) {
		this.sms_size = sms_size;
	}

	/**
	 * 是否接收成功
	 * @author 苏行利
	 * @return 是否接收成功
	 * @date 2019-08-28 16:11:57
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * 设置是否接收成功
	 * @author 苏行利
	 * @param success 是否接收成功
	 * @date 2019-08-28 16:12:05
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 获取状态报告编码
	 * @author 苏行利
	 * @return 状态报告编码
	 * @date 2019-08-28 16:12:15
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置状态报告编码
	 * @author 苏行利
	 * @param code 状态报告编码
	 * @date 2019-08-28 16:12:20
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取状态报告说明
	 * @author 苏行利
	 * @return 状态报告说明
	 * @date 2019-08-28 16:12:33
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 设置状态报告说明
	 * @author 苏行利
	 * @param msg 状态报告说明
	 * @date 2019-08-28 16:12:37
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 获取发送时间
	 * @author 苏行利
	 * @return 发送时间
	 * @date 2019-08-28 16:12:50
	 */
	public Date getSend_time() {
		return send_time;
	}

	/**
	 * 设置发送时间
	 * @author 苏行利
	 * @param send_time 发送时间
	 * @date 2019-08-28 16:12:55
	 */
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}

	/**
	 * 获取状态报告时间
	 * @author 苏行利
	 * @return 状态报告时间
	 * @date 2019-08-28 16:13:07
	 */
	public Date getReport_time() {
		return report_time;
	}

	/**
	 * 设置状态报告时间
	 * @author 苏行利
	 * @param report_time 状态报告时间
	 * @date 2019-08-28 16:13:14
	 */
	public void setReport_time(Date report_time) {
		this.report_time = report_time;
	}
}
