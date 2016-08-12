package service;

import javax.servlet.http.Cookie;

import entity.Information;

public interface DetailService {
	//根据type和id获取详细信息
	Information getInformation(Cookie[] cookies,String type,String id);
}
