package entity;

public class OutLine {
	private long id;
	private String title;
	private String date;
	private String autor;
	private String state;
	public OutLine(long id, String title, String date, String autor, String state) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.autor = autor;
		this.state = state;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	
}
