package service;

public interface WechatService {
	//获取微信授权（主要用于推送和更新按钮），因为每天调用次数有限，所以之后需要做成在授权过期之后再去重新生成
	public String getToken();
	
	//在用户点击按钮时获取openid
	public String getOpenID(String code);
	
	//生成个人设置和我的审批两个按钮
	public String initButtons();
}
