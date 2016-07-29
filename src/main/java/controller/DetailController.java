package controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Information;
import service.DetailService;

@Controller
public class DetailController {
	private static final String DETAIL="detail";
	
	@Autowired
	DetailService detailService;
	
	@RequestMapping(value="/detail", method = { RequestMethod.GET, RequestMethod.POST })
	public String getTab(HttpServletRequest request,Map<String, Object> map){
		Cookie[] cookies=request.getCookies();
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		Information information=detailService.getInformation(cookies, type, id);
		map.put("information", information);
		return DETAIL;
	}
}
