package controller;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.auth.MalformedChallengeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Department;
import entity.Operation;
import entity.SubmitEntity;
import net.sf.json.JSONObject;
import service.SubmitService;
import service.UserService;

@Controller
public class SubmitController {
	
	public static final String SUBMIT="submit";
	
	@Autowired
	private SubmitService submitService;
	
	@Autowired
	private UserService UserService;
	
	
	@RequestMapping(value="/submit",method={ RequestMethod.GET, RequestMethod.POST }) 
	public String submit(HttpServletRequest request,
			Map<String, Object> map,HttpServletResponse response){
		Cookie[] cookies=request.getCookies();
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		List<Operation> operations=submitService.getOperation(cookies, type, id);
		map.put("operations", operations);
		for(Operation operation:operations){
			if(operation.isHasOptions()&&operation.getOptions().size()==0){
				List<Department> departments=UserService.getDepartments(cookies);
				map.put("departments", departments);
			}
		}
		map.put("type",type);
		map.put("id",id);
		return SUBMIT;
	}
	
	@RequestMapping(value="/aftersubmit",method={ RequestMethod.GET, RequestMethod.POST }) 
	public @ResponseBody String reject(HttpServletRequest request,
			Map<String, Object> map,HttpServletResponse response){
		Cookie[] cookies=request.getCookies();
		try{
			request.setCharacterEncoding("utf-8");
		}catch(Exception e){
			
		}
		String id=request.getParameter("id"); 
		String type=request.getParameter("type"); 
		String nextnode=request.getParameter("nextnode"); 
		String fieldapproval=request.getParameter("fieldapproval"); 
		String documentid=request.getParameter("documentid"); 
		String actionname=request.getParameter("actionname"); 
		String checkdate=request.getParameter("checkdate"); 
		String nextstepusername=request.getParameter("nextstepusername"); 
		Map<String, String> responseMap=submitService.submit(cookies, new SubmitEntity(nextnode, fieldapproval, documentid, actionname, checkdate, nextstepusername),type,id);
		map.putAll(responseMap);
		String answer=JSONObject.fromObject(map).toString();
		return answer;
	}
}
