package controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jcp.xml.dsig.internal.MacOutputStream;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Exception.InvalidUserException;
import entity.OutLine;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.CheckService;
import service.LoginService;
import wechat.Connection.OpenID;


@Controller
public class LoginController {
	public static final String LOGIN="login";
	public static final String CHECK="check";
	
	
	@Autowired
	private CheckService checkService;
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
	@ResponseBody
	public  Map<String , Object> login(HttpServletRequest request,Map<String, Object> map,HttpServletResponse response){
		String username=request.getParameter("username"); 
		String password=request.getParameter("password");
		System.out.println(username);
		try{
			Cookie cookie=loginService.login(username, password);
			response.addCookie(cookie);

			map.put("msg", "OK");
			return map;
		}catch(InvalidUserException e){
			map.put("msg", "error");
//			try{
//				PrintWriter printWriter=response.getWriter();
//				System.out.println(JSONObject.fromObject(map).toString());
//				printWriter.write(JSONObject.fromObject(map).toString());
//			}catch(Exception e1){
//				
//			}
			
			return map;
			
		}
	}
		
	@RequestMapping(value="/getCheck", method = { RequestMethod.GET, RequestMethod.POST })
	public String getCheck(HttpServletRequest request,Map<String, Object> map){
		Cookie[] cookies=request.getCookies();
		List<OutLine> outLines=checkService.getOutLines(cookies);
		map.put("outlines", outLines);
		return CHECK;
	}
			
}