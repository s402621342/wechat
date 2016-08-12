package service;

import java.util.List;

import javax.servlet.http.Cookie;

import entity.OutLine;
import entity.Tab;

public interface CheckService {
	//获取审批内容的概要列表
	List<OutLine> getOutLines(Cookie[] cookies,String type);
	
	//获取类别列表（收文、发文等）
	List<Tab> getTabs(Cookie[] cookies);
}
