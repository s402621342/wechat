package service.Impl;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.PathDAO;
import DAO.UserDAO;
import entity.Department;
import model.Path;
import model.User;
import service.UserService;
import wechat.HttpHelp;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PathDAO propertyDAO;
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<Department> getDepartments(Cookie[] cookies) {
		// TODO Auto-generated method stub
		Path property=propertyDAO.getByCode("departmentlist");
		String url=property.getPath();
		url=url.replace("{0}", "");
		List<Department> departments=new ArrayList<>();
		String cookieStr="";
		for(int i=0;i<cookies.length;i++){
			if(i!=0){
				cookieStr+=";";
			}
			cookieStr+=cookies[i].getName()+"="+cookies[i].getValue();
		}
		String response=HttpHelp.getResponseByCookie(url, "", cookieStr);
		Document document=Jsoup.parse(response);
		Elements elements=document.select("department");
		for(Element element:elements){
			String id="";
			try{
				id=URLEncoder.encode(element.attr("id"), "utf-8");
			}catch(Exception e){
				
			}
			String name=element.attr("name");
			Path property2=propertyDAO.getByCode("userList");
			String url2=property2.getPath();
			url2=url2.replace("{0}", id);
			String response2=HttpHelp.getResponseByCookie(url2, "", cookieStr);
			Document document2=Jsoup.parse(response2);
			Elements elements2=document2.select("user");
			List<String> usernames=new ArrayList<>();
			for(Element element2:elements2){
				usernames.add(element2.attr("fullname"));
			}
			departments.add(new Department(name, usernames));
		}
		return departments;
		
	}

	@Override
	public User getUserByID(String id) {
		// TODO Auto-generated method stub
		return userDAO.getUserByID(id);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDAO.addUser(user);
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		userDAO.deleteUser(username);
	}

}
