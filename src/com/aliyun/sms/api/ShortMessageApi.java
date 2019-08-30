package com.aliyun.sms.api;

import com.aliyun.sms.ShortMessageContext;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 短信接口
 * @author 苏行利
 * @date 2019-08-30 14:14:53
 */
public class ShortMessageApi {
	private static final ShortMessageContext ctx = ShortMessageContext.getInstance();
	
	/**
	 * 发送短信验证码
	 * @author 苏行利
	 * @param mobile 手机号码
	 * @param vcode 验证码
	 * @throws ServerException
	 * @throws ClientException
	 * @date 2019-08-30 14:15:14
	 */
	public static void sendSMSCode(String mobile, String vcode) throws ServerException, ClientException {
		DefaultProfile profile = DefaultProfile.getProfile(ctx.getRegion_id(), ctx.getAccess_key_id(), ctx.getAccess_secret());
		IAcsClient client = new DefaultAcsClient(profile);
		CommonRequest request = new CommonRequest();
		request.setMethod(MethodType.POST);
		request.setDomain(ctx.getDomain());
		request.setVersion(ctx.getVersion());
		request.setAction(ctx.getAction());
		request.putQueryParameter("SignName", ctx.getSign_name());
		request.putQueryParameter("TemplateCode", ctx.getTemplate_code());
		request.putQueryParameter("TemplateParam", "{\"code\":\"" + vcode + "\"}");
		request.putQueryParameter("PhoneNumbers", mobile);
		client.getCommonResponse(request);
	}

}
