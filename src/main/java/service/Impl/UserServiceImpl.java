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

import DAO.UserDAO;
import entity.Department;
import model.User;
import service.UserService;
import wechat.Connection.HttpHelp;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<Department> getDepartments(Cookie[] cookies) {
		// TODO Auto-generated method stub
		List<Department> departments=new ArrayList<>();
		String url="http://shqingyuan.f3322.net:81/xsgs/api.nsf/departmentList?openagent";
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
			String url2="http://shqingyuan.f3322.net:81/xsgs/api.nsf/userList?openagent&departmentId="+id;
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

}
