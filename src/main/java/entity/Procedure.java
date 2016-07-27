package entity;

public class Procedure {
	private long number;
	private String date;
	private String name;
	private String department;
	private String action;
	public Procedure(long number, String date, String name, String department, String action) {
		super();
		this.number = number;
		this.date = date;
		this.name = name;
		this.department = department;
		this.action = action;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
}
