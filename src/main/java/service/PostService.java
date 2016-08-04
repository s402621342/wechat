package service;

import entity.PostEntity;

public interface PostService {
	public String post(PostEntity entity);
	
	public PostEntity analysis(String PostItem);
}
