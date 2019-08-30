
package com.aliyun.sms;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.aliyun.sms.listener.ShortMessageReceiveListener;
import com.aliyun.sms.util.ShortMessageUtil;

/**
 * 短信上下文
 * @author 苏行利
 * @date 2019-08-28 16:13:33
 */
public class ShortMessageContext {
	private static ShortMessageContext context;
	private String access_key_id;
	private String access_secret;
	private String region_id;
	private String domain;
	private String version;
	private String action;
	private String template_code;
	private String sign_name;
	private ShortMessageReceiveListener listener;

	/**
	 * 构造方法
	 * @author 苏行利
	 * @date 2019-08-28 16:13:44
	 */
	private ShortMessageContext() {

	}

	/**
	 * 获取上下文实例
	 * @author 苏行利
	 * @return 上下文实例
	 * @date 2019-08-28 16:13:49
	 */
	public static ShortMessageContext getInstance() {
		if (context != null) {
			return context;
		}
		synchronized (ShortMessageContext.class) {
			if (context == null) {
				context = new ShortMessageContext();
				try {
					Document doc = new SAXReader().read(ShortMessageUtil.class.getResourceAsStream("/aliyun-sms-cfg.xml"));
					Element root = doc.getRootElement();
					context.access_key_id = root.elementTextTrim("access_key_id");
					context.access_secret = root.elementTextTrim("access_secret");
					context.region_id = root.elementTextTrim("region_id");
					context.domain = root.elementTextTrim("domain");
					context.version = root.elementTextTrim("version");
					context.action = root.elementTextTrim("action");
					context.template_code = root.elementTextTrim("template_code");
					context.sign_name = root.elementTextTrim("sign_name");
					List<Element> listeners = root.elements("listener");
					for (Element listener : listeners) {
						if ("shortMessageReceiveListener".equals(listener.attributeValue("id"))) {
							try {
								context.listener = (ShortMessageReceiveListener) Class.forName(listener.attributeValue("class")).newInstance();
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (InstantiationException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							}
						}
					}
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
		}
		return context;
	}

	/**
	 * 获取访问密钥Id
	 * @author 苏行利
	 * @return 访问密钥Id
	 * @date 2019-08-28 16:14:28
	 */
	public String getAccess_key_id() {
		return access_key_id;
	}

	/**
	 * 获取访问密钥
	 * @author 苏行利
	 * @return 访问密钥
	 * @date 2019-08-28 16:14:39
	 */
	public String getAccess_secret() {
		return access_secret;
	}

	/**
	 * 获取API支持的regionId
	 * @author 苏行利
	 * @return API支持的regionId
	 * @date 2019-08-28 16:14:53
	 */
	public String getRegion_id() {
		return region_id;
	}

	/**
	 * 获取API域名
	 * @author 苏行利
	 * @return API域名
	 * @date 2019-08-28 16:15:04
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * 获取API的版本号
	 * @author 苏行利
	 * @return API的版本号(格式为 yyyy-MM-dd)
	 * @date 2019-08-28 16:15:14
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 获取API名称
	 * @author 苏行利
	 * @return API名称
	 * @date 2019-08-28 16:15:32
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 获取短信模板Id
	 * @author 苏行利
	 * @return 短信模板Id
	 * @date 2019-08-28 16:15:43
	 */
	public String getTemplate_code() {
		return template_code;
	}

	/**
	 * 获取短信签名名称
	 * @author 苏行利
	 * @return 短信签名名称
	 * @date 2019-08-28 16:15:53
	 */
	public String getSign_name() {
		return sign_name;
	}

	/**
	 * 获取短信回执监听器
	 * @author 苏行利
	 * @return 短信回执监听器
	 * @date 2019-08-28 16:16:01
	 */
	public ShortMessageReceiveListener getListener() {
		return listener;
	}
}
