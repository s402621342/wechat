package service;

import javax.servlet.http.Cookie;

import exception.InvalidUserException;

public interface LoginService {
	public Cookie login(String username,String password) throws InvalidUserException;
}
