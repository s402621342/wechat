package entity;

import java.util.List;
import java.util.Map;

public class Information {
	private String id;
	
	private String type;

	private boolean canOperate;
	
	private Map<DisplayName, Map<String, String>> basicInfo;		//概要，其他信息
	
	private Map<DisplayName, Map<String, String>> attachment;		//附件，正文
	
	private Map<DisplayName, List<OtherInfo>> otherInfo;				//流程、意见等

	public Information(String id, String type, boolean canOperate, Map<DisplayName, Map<String, String>> basicInfo,
			Map<DisplayName, Map<String, String>> attachment, Map<DisplayName, List<OtherInfo>> otherInfo) {
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

	public Map<DisplayName, Map<String, String>> getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(Map<DisplayName, Map<String, String>> basicInfo) {
		this.basicInfo = basicInfo;
	}

	public Map<DisplayName, Map<String, String>> getAttachment() {
		return attachment;
	}

	public void setAttachment(Map<DisplayName, Map<String, String>> attachment) {
		this.attachment = attachment;
	}

	public Map<DisplayName, List<OtherInfo>> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(Map<DisplayName, List<OtherInfo>> otherInfo) {
		this.otherInfo = otherInfo;
	}

	
	
}
