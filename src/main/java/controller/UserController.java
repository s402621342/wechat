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
public class UserController {
	
	public static final String SETTINGLOGIN="settinglogin";
	public static final String SETTING="setting";
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/settinglogin",method={ RequestMethod.GET, RequestMethod.POST }) 
	public String settinglogin(HttpServletRequest request,
			Map<String, Object> map,HttpServletResponse response){
		String openId="";
		try{
			String code=request.getParameter("code");
			openId=OpenID.getOpenID(code);
		}catch(Exception e){
			openId=(String)request.getSession().getAttribute("openid");
		}
		User user=userService.getUserByID(openId);
		if(user!=null){
			String username=user.getUsername();
			String password=user.getPassword();
			try{
				Cookie cookie=loginService.login(username, password);
				response.addCookie(cookie);
				request.getSession().setAttribute("openid", openId);
				return "redirect:/setting";
			}catch(InvalidUserException e){									//密码更改
				request.getSession().setAttribute("openid", openId);
				return SETTINGLOGIN;
			}
		}else{
		
			request.getSession().setAttribute("openid", openId);
			
			return SETTINGLOGIN;
		}
	}
	
	
	
	@RequestMapping(value="/setting",method={ RequestMethod.GET, RequestMethod.POST }) 
	public String setting(HttpServletRequest request,
			Map<String, Object> map,HttpServletResponse response){
		String openid=(String)request.getSession().getAttribute("openid");
		String username=userService.getUserByID(openid).getUsername();
		map.put("username", username);
		return SETTING;
	}
	@RequestMapping(value="/logout",method={ RequestMethod.GET, RequestMethod.POST }) 
	public @ResponseBody String logout(HttpServletRequest request,
			Map<String, Object> map,HttpServletResponse response){
		String openid=(String)request.getSession().getAttribute("openid");
		try{
			userService.deleteUser(openid);
			map.put("success", "true");
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", "false");
		}
		return JSONObject.fromObject(map).toString();
	}
}
