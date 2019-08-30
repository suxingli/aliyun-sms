package com.aliyun.sms.listener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.aliyun.sms.bean.ShortMessageReceive;
import com.aliyun.sms.exception.ShortMessageReceiveException;

/**
 * 短信回执监听器实现类
 * @author 苏行利
 * @date 2019-08-28 11:44:26
 */
public class ShortMessageReceiveListenerImpl implements ShortMessageReceiveListener {

	@Override
	public void receive(ShortMessageReceive... receives) throws ShortMessageReceiveException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer buffer = new StringBuffer();
		buffer.append("[").append("\n");
		for (ShortMessageReceive receive : receives) {
			buffer.append("\t").append("{").append("\n");
			buffer.append("\t\t").append("\"phone_number\":").append("\"").append(receive.getPhone_number()).append("\"").append(",").append("\n");
			buffer.append("\t\t").append("\"biz_id\":").append("\"").append(receive.getBiz_id()).append("\"").append(",").append("\n");
			buffer.append("\t\t").append("\"out_id\":").append("\"").append(receive.getOut_id()).append("\"").append(",").append("\n");
			buffer.append("\t\t").append("\"sms_size\":").append(receive.getSms_size()).append(",").append("\n");
			buffer.append("\t\t").append("\"success\":").append(receive.isSuccess()).append(",").append("\n");
			buffer.append("\t\t").append("\"code\":").append("\"").append(receive.getCode()).append("\"").append(",").append("\n");
			buffer.append("\t\t").append("\"msg\":").append("\"").append(receive.getMsg()).append("\"").append(",").append("\n");
			buffer.append("\t\t").append("\"send_time\":").append("\"").append(dateFormat.format(receive.getSend_time())).append("\"").append(",").append("\n");
			buffer.append("\t\t").append("\"report_time\":").append("\"").append(dateFormat.format(receive.getReport_time())).append("\"").append(",").append("\n");
			buffer.append("\t").append("}").append("\n");
		}
		buffer.append("]");
		System.out.println(buffer);
	}

}
