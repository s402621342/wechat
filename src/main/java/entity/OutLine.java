package entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("listitem")
public class OutLine {
	
	@XStreamAlias("itemid")
	private String id;
	
	@XStreamAlias("title")
	private String title;
	
	@XStreamAlias("field3")
	private String date;
	
	@XStreamAlias("field1")
	private String autor;
	
	@XStreamAlias("field2")
	private String state;
	
	@XStreamAlias("canopen")
	private long canopen;
	
	public OutLine(String id, String title, String date, String autor, String state) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.autor = autor;
		this.state = state;
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
	
	
}
