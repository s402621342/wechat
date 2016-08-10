package service;

public interface WechatService {
	public String getToken();
	
	public String getOpenID(String code);
	
	public String initButtons();
}
