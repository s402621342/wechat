package service;

import java.util.List;

import javax.servlet.http.Cookie;

import entity.Information;
import entity.OutLine;

public interface CheckService {
	Information getInformation(String id);
	
	List<OutLine> getOutLines(Cookie[] cookies);
}
