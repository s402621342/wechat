package entity;


//用于显示detail中的项目名称，如概要、其他信息，以及是否展开
public class DisplayName {
	String name;
	String display;
	public DisplayName(String name, String display) {
		super();
		this.name = name;
		this.display = display;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}

	
}
