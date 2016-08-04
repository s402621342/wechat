package service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import entity.Operation;
import entity.SubmitEntity;

public interface SubmitService {
	public List<Operation> getOperation(Cookie[] cookies,String type,String id);
	
	
	public Map<String, String> submit(Cookie[] cookies,SubmitEntity entity,String type,String id);
	
}
