package service;

import java.util.List;

import javax.servlet.http.Cookie;

import entity.Department;
import model.User;

public interface UserService {
	//获取所有部门（包括部门中所有人员的名字）
	public List<Department> getDepartments(Cookie[] cookies);
	
	//根据openid获取用户（登录时使用）
	public User getUserByID(String id);
	
	//用户登录时增加一条信息（用于免登录）
	public void addUser(User user);
	
	//用户注销时调用
	public void deleteUser(String username);
}
