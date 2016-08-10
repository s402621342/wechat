package entity;


public class Button {
	String type;
	String name;
	String key;
	String url;
	public Button(String type, String name, String key, String url) {
		super();
		this.type = type;
		this.name = name;
		this.key = key;
		this.url = url;
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
