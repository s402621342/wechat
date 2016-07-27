package wechat.Connection;

import net.sf.json.JSONObject;

public class OpenID {
	public static String getOpenID(String code){
		String uri="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+Property.getAppID()+"&secret="+Property.getAppSecret()+"&code="+code+"&grant_type=authorization_code";
		String response=HttpHelp.createhttpClient(uri, "");
		JSONObject json=JSONObject.fromObject(response);
		String OpenID=json.get("openid").toString();
		return OpenID;
	}
}
