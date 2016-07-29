package entity;

import java.util.List;
import java.util.Map;

public class Information {
	private Map<String, String> outline;
	
	private Map<String, String> otherInfo;
	
	private Map<String, String> attachment;
	
	//是否有正文
	private boolean hasText;
	
	private Map<String, String> text;

	
	private List<Procedure> procedures;
	
	
	private Map<ViewHead, List<View>> views;


	public Map<ViewHead, List<View>> getViews() {
		return views;
	}

	public void setViews(Map<ViewHead, List<View>> views) {
		this.views = views;
	}

	public Information(Map<String, String> outline, Map<String, String> otherInfo, Map<String, String> attachment,
			boolean hasText, Map<String, String> text, List<Procedure> procedures, Map<ViewHead, List<View>> views) {
		super();
		this.outline = outline;
		this.otherInfo = otherInfo;
		this.attachment = attachment;
		this.hasText = hasText;
		this.text = text;
		this.procedures = procedures;
		this.views = views;
	}

	public Map<String, String> getOutline() {
		return outline;
	}

	public void setOutline(Map<String, String> outline) {
		this.outline = outline;
	}

	public Map<String, String> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(Map<String, String> otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Map<String, String> getAttachment() {
		return attachment;
	}

	public void setAttachment(Map<String, String> attachment) {
		this.attachment = attachment;
	}

	public boolean isHasText() {
		return hasText;
	}

	public void setHasText(boolean hasText) {
		this.hasText = hasText;
	}

	public Map<String, String> getText() {
		return text;
	}

	public void setText(Map<String, String> text) {
		this.text = text;
	}

	public List<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}
	
	

	

}
