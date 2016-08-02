package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Department;
import entity.Operation;
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
		return SUBMIT;
	}
	
	@RequestMapping(value="/reject",method={ RequestMethod.GET, RequestMethod.POST }) 
	public void reject(HttpServletRequest request,
			Map<String, Object> map,HttpServletResponse response){
		
	}
}
