package entity;

import java.util.List;

public class Department {
	String name;
	List<String> usernames;
	public Department(String name, List<String> usernames) {
		super();
		this.name = name;
		this.usernames = usernames;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUsernames() {
		return usernames;
	}
	public void setUsernames(List<String> usernames) {
		this.usernames = usernames;
	}
	
}
