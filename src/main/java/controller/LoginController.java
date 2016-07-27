package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.OutLine;
import service.checkService;
import wechat.Connection.OpenID;


@Controller
public class LoginController {
	public static final String LOGIN="login";
	public static final String CHECK="check";
	
	
	@Autowired
	private checkService checkService;
	
	
	//载入登录界面
	@RequestMapping(value="/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String prelogin(HttpServletRequest request){
		String code=request.getParameter("code");
		System.out.println(OpenID.getOpenID(code));
		return LOGIN;
	}
	
	@RequestMapping(value="/checklogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(HttpServletRequest request,Map<String, Object> map){
		String username=request.getParameter("username"); 
		String password=request.getParameter("password");
		if("admin".equals(username)&&"123".equals(password)){
			List<OutLine> outLines=checkService.getOutLines(username);
			map.put("outlines", outLines);
			return CHECK;
		}else{
			
			return LOGIN;
		}
	}
}