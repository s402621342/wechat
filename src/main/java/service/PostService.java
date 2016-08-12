package service;

import entity.PostEntity;

public interface PostService {
	//将信息推送到微信上
	public String post(PostEntity entity);
	
	//将传过来的字符串解析为类
	public PostEntity analysis(String PostItem);
}
