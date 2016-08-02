package controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Exception.InvalidUserException;
import net.sf.json.JSONObject;
import service.LoginService;


@Controller
public class LoginController {
	public static final String LOGIN="login";
	
	@Autowired
	private LoginService loginService;
	
	//载入登录界面
	@RequestMapping(value="/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String prelogin(HttpServletRequest request){
//		String code=request.getParameter("code");
//		System.out.println(OpenID.getOpenID(code));
		return LOGIN;
	}
	
	@RequestMapping(value="/checklogin", method = { RequestMethod.GET, RequestMethod.POST })
	public 	@ResponseBody String login(HttpServletRequest request,
			Map<String, Object> map,HttpServletResponse response){
		try{
			request.setCharacterEncoding("utf-8");
		}catch(Exception e){
			
		}
		try{
		String username=request.getParameter("username"); 
		String password=request.getParameter("password");
			Cookie cookie=loginService.login(username, password);
			response.addCookie(cookie);
			map.put("success", "true");
		}catch(InvalidUserException e){
			map.put("success", "false");
		}
		return JSONObject.fromObject(map).toString();
	}

	
			
}