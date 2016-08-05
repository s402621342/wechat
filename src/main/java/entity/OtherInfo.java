package entity;

import java.util.Map;

//detail中的流程、意见等
public class OtherInfo {
	private Map<String, Map<String, Boolean>> info;				//boolean为了查看是否为图片

	public OtherInfo(Map<String, Map<String, Boolean>> info) {
		super();
		this.info = info;
	}

	public Map<String, Map<String, Boolean>> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Map<String, Boolean>> info) {
		this.info = info;
	}
	
	
}
