package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.OutLine;
import entity.Tab;
import service.CheckService;

@Controller
public class CheckController {
	

	public static final String CHECK="check";
	public static final String TAB="tab";
	
	@Autowired
	private CheckService checkService;
	
	
	
	@RequestMapping(value="/getTab", method = { RequestMethod.GET, RequestMethod.POST })
	public String getTab(HttpServletRequest request,Map<String, Object> map){
		Cookie[] cookies=request.getCookies();
		List<Tab> tabs=checkService.getTabs(cookies);
		map.put("tabs", tabs);
		return TAB;
	}
	
		
	@RequestMapping(value="/getCheck", method = { RequestMethod.GET, RequestMethod.POST })
	public String getCheck(HttpServletRequest request,Map<String, Object> map){
		String type=request.getParameter("type");
		Cookie[] cookies=request.getCookies();
		List<OutLine> outLines=checkService.getOutLines(cookies, type);
		map.put("outlines", outLines);
		return CHECK;
	}
	
		
}
