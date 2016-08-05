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

import exception.InvalidUserException;
import model.User;
import net.sf.json.JSONObject;
import service.LoginService;
import service.UserService;
import wechat.Connection.OpenID;


@Controller
public class LoginController {
	public static final String LOGIN="login";
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	//载入登录界面
	@RequestMapping(value="/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String prelogin(HttpServletRequest request,Map<String, Object> map,HttpServletResponse response){
		String code=request.getParameter("code");
		String openId="";
		openId=OpenID.getOpenID(code);
		User user=userService.getUserByID(openId);
		if(user!=null){
			String username=user.getUsername();
			String password=user.getPassword();
			try{
				Cookie cookie=loginService.login(username, password);
				response.addCookie(cookie);
				return "redirect:/getTab";
			}catch(InvalidUserException e){									//密码更改
				request.getSession().setAttribute("openid", openId);
				return LOGIN;
			}
		}else{
		
			request.getSession().setAttribute("openid", openId);
			
			return LOGIN;
		}
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
			String openid=(String)request.getSession().getAttribute("openid");
			Cookie cookie=loginService.login(username, password);
			response.addCookie(cookie);
			map.put("success", "true");
			User user=new User();
			user.setId(openid);
			user.setPassword(password);
			user.setUsername(username);
			userService.addUser(user);
		}catch(InvalidUserException e){
			map.put("success", "false");
		}
		return JSONObject.fromObject(map).toString();
	}

	
			
}