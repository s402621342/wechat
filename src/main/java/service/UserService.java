package service;

import java.util.List;

import javax.servlet.http.Cookie;

import entity.Department;

public interface UserService {
	public List<Department> getDepartments(Cookie[] cookies);
}
