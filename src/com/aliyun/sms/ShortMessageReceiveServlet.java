package com.aliyun.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aliyun.sms.bean.ShortMessageReceive;
import com.aliyun.sms.exception.ShortMessageReceiveException;
import com.aliyun.sms.listener.ShortMessageReceiveListener;
import com.aliyun.sms.util.ServletUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 短信回执处理
 * @author 苏行利
 * @date 2019-08-28 10:28:09
 */
@WebServlet(name = "shortmessage_receive", value = "/aliyuncs/sms/receive", loadOnStartup = 1)
public class ShortMessageReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = -3452154732055169389L;
	private static final String encode = "UTF-8";
	private static final String contentType = "application/json; charset=" + encode;
	private static final ShortMessageReceiveListener listener = ShortMessageContext.getInstance().getListener();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(contentType);
		try {
			JSONArray result = JSONArray.fromObject(ServletUtil.getRequestContent(request));
			if (result.size() == 0) {
				return;
			}
			JSONObject _receive = null;
			ShortMessageReceive[] receives = new ShortMessageReceive[result.size()];
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0, len = result.size(); i < len; i++) {
				_receive = result.getJSONObject(i);
				receives[i] = new ShortMessageReceive();
				receives[i].setPhone_number(_receive.getString("phone_number"));
				receives[i].setBiz_id(_receive.has("biz_id") ? _receive.getString("biz_id") : null);
				receives[i].setOut_id(_receive.has("out_id") ? _receive.getString("out_id") : null);
				receives[i].setSms_size(_receive.getInt("sms_size"));
				receives[i].setSuccess(_receive.getBoolean("success"));
				receives[i].setCode(_receive.getString("err_code"));
				receives[i].setMsg(_receive.getString("err_msg"));
				receives[i].setSend_time(dateFormat.parse(_receive.getString("send_time")));
				receives[i].setReport_time(dateFormat.parse(_receive.getString("report_time")));
			}
			listener.receive(receives);
		} catch (ParseException e) {
			PrintWriter out = response.getWriter();
			out.append("{");
			out.append("\"").append("code").append("\"").append(":").append("-1").append(",");
			out.append("\"").append("msg").append("\"").append(":").append("\"").append("日期格式不合法").append("\"");
			out.append("}");
			out.flush();
			out.close();
			return;
		} catch (ShortMessageReceiveException e) {
			PrintWriter out = response.getWriter();
			out.append("{");
			out.append("\"").append("code").append("\"").append(":").append(e.getCode()).append(",");
			out.append("\"").append("msg").append("\"").append(":").append("\"").append(e.getMessage()).append("\"");
			out.append("}");
			out.flush();
			out.close();
			return;
		}
		PrintWriter out = response.getWriter();
		out.append("{");
		out.append("\"").append("code").append("\"").append(":").append("0").append(",");
		out.append("\"").append("msg").append("\"").append(":").append("\"").append("接收成功").append("\"");
		out.append("}");
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
