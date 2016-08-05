package entity;

import java.util.List;
import java.util.Map;

public class Information {
	private String id;
	
	private String type;

	private boolean canOperate;
	
	private Map<String, Map<String, String>> basicInfo;
	
	private Map<String, Map<String, String>> attachment;
	
	private Map<String, List<OtherInfo>> otherInfo;				//流程、意见等

	public Information(String id, String type, boolean canOperate, Map<String, Map<String, String>> basicInfo,
			Map<String, Map<String, String>> attachment, Map<String, List<OtherInfo>> otherInfo) {
		super();
		this.id = id;
		this.type = type;
		this.canOperate = canOperate;
		this.basicInfo = basicInfo;
		this.attachment = attachment;
		this.otherInfo = otherInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isCanOperate() {
		return canOperate;
	}

	public void setCanOperate(boolean canOperate) {
		this.canOperate = canOperate;
	}

	public Map<String, Map<String, String>> getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(Map<String, Map<String, String>> basicInfo) {
		this.basicInfo = basicInfo;
	}

	public Map<String, Map<String, String>> getAttachment() {
		return attachment;
	}

	public void setAttachment(Map<String, Map<String, String>> attachment) {
		this.attachment = attachment;
	}

	public Map<String, List<OtherInfo>> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(Map<String, List<OtherInfo>> otherInfo) {
		this.otherInfo = otherInfo;
	}
	


	


	

}
