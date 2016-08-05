package controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Information;
import exception.InvalidUserException;
import model.User;
import service.DetailService;
import service.LoginService;
import service.UserService;
import wechat.Connection.OpenID;

@Controller
public class DetailController {
	private static final String DETAIL="detail";
	public static final String LOGIN="login";
	
	@Autowired
	private DetailService detailService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/detail", method = { RequestMethod.GET, RequestMethod.POST })
	public String getTab(HttpServletRequest request,Map<String, Object> map){
		Cookie[] cookies=request.getCookies();
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		Information information=detailService.getInformation(cookies, type, id);
		map.put("information", information);
		return DETAIL;
	}
	
	//直接进入detail
	@RequestMapping(value="/toDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String getDetail(HttpServletRequest request,Map<String, Object> map,HttpServletResponse response){
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
				Cookie[] cookies=new Cookie[1];
				cookies[0]=cookie;
				String type=request.getParameter("type");
				String id=request.getParameter("id");
				Information information=detailService.getInformation(cookies, type, id);
				map.put("information", information);
				return DETAIL;
			}catch(InvalidUserException e){									//密码更改
				request.getSession().setAttribute("openid", openId);
				return LOGIN;
			}
		}else{
		
			request.getSession().setAttribute("openid", openId);
			
			return LOGIN;
		}
	}
}
