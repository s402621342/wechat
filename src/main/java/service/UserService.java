package service;

import java.util.List;

import javax.servlet.http.Cookie;

import entity.Department;
import model.User;

public interface UserService {
	public List<Department> getDepartments(Cookie[] cookies);
	
	public User getUserByID(String id);
	
	public void addUser(User user);
	
	public void deleteUser(String username);
}
