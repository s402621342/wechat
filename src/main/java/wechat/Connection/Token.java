package wechat.Connection;

import net.sf.json.JSONObject;

public class Token {
    public static String getToken(){
    	String appID =Property.getAppID();
        String appsecret = Property.getAppSecret();
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appsecret;
        String response=HttpHelp.createhttpClient(url,"");
        JSONObject json=JSONObject.fromObject(response);
        String ACCESS_TOKEN=json.get("access_token").toString();
	return ACCESS_TOKEN;
	
}
}
