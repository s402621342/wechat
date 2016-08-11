package DAO;

import java.util.List;

import model.User;

public interface UserDAO {
	public User getUserByID(String id);
	
	public void addUser(User user);
	
	public List<User> getUserByName(String username);
	
	public void deleteUser(String username);
	
}
