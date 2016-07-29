package entity;

public class OutLine {
	private String id;
	
	private String title;
	
	private String date;
	
	private String autor;
	
	private String state;
	
	private long canopen;
	
	private String type;
	
	public OutLine(String id, String title, String date, String autor, String state, long canopen, String type) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.autor = autor;
		this.state = state;
		this.canopen = canopen;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getCanopen() {
		return canopen;
	}
	public void setCanopen(long canopen) {
		this.canopen = canopen;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
