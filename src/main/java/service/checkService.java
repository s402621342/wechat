package service;

import java.util.List;

import javax.servlet.http.Cookie;

import entity.OutLine;
import entity.Tab;

public interface CheckService {
	
	List<OutLine> getOutLines(Cookie[] cookies,String type);
	
	List<Tab> getTabs(Cookie[] cookies);
}
