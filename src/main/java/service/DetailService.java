package service;

import javax.servlet.http.Cookie;

import entity.Information;

public interface DetailService {
	Information getInformation(Cookie[] cookies,String type,String id);
}
