package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="information")
public class Info {
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="value")
	private String value;
	@Column(name="type")
	private String type;

	public Info() {
		super();
	}

	public Info(String name, String value, String type) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
