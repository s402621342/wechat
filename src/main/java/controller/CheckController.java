package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Information;
import service.CheckService;

@Controller
public class CheckController {
	
	private static final String DETAIL="detail";
	
	@Autowired
	private CheckService checkService;
	
	
	
	@RequestMapping(value = "/check", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(HttpServletRequest request,  Map<String, Object> map) {
		String id =request.getParameter("id");
		Information information=checkService.getInformation(id);
		map.put("information", information);
		return DETAIL;
	}
		
}
