package entity;

public class Tab implements Comparable<Tab>{
	private String type;
	private String name;
	private long number;
	public Tab(String type, String name, long number) {
		super();
		this.type = type;
		this.name = name;
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	@Override
	public int compareTo(Tab o) {
		// TODO Auto-generated method stub
		return (int)(o.number-this.number);
	}
	
	
}
