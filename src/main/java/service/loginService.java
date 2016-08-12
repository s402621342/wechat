package service;

import javax.servlet.http.Cookie;

import exception.InvalidUserException;

public interface LoginService {
	//登录用
	public Cookie login(String username,String password) throws InvalidUserException;
}
