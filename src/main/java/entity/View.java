package entity;

public class View {
	private String name;
	private String date;
	private String opinion;
	private String sign;
	public View(String name, String date, String opinion, String sign) {
		super();
		this.name = name;
		this.date = date;
		this.opinion = opinion;
		this.sign = sign;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
