package service;

import java.util.List;

import javax.servlet.http.Cookie;

import entity.Operation;

public interface SubmitService {
	public List<Operation> getOperation(Cookie[] cookies,String type,String id);
}
