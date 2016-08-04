package DAO;

import model.User;

public interface UserDAO {
	public User getUserByID(String id);
	
	public void addUser(User user);
	
	public User getUserByName(String username);
	
}
