package entity;

import java.util.List;
import java.util.Map;

public class Information {
	private String id;
	private String title;
	private String number;
	private String draftDate;
	private String secret;
	private String urgency;
	private String drafter;
	private String draftVerification;
	private String subject;
	private String employer;
	private String report;
	private String copy;
	private String printDate;
	private String remark;
	private String state;
	private String text;
	private Map<String,String> attachment;
	private List<Procedure> procedures;
	private List<View> examineView;
	private List<View> readView;
	public Information(String id, String title, String number, String draftDate, String secret, String urgency,
			String drafter, String draftVerification, String subject, String employer, String report, String copy,
			String printDate, String remark, String state, String text, Map<String, String> attachment,
			List<Procedure> procedures, List<View> examineView, List<View> readView) {
		super();
		this.id = id;
		this.title = title;
		this.number = number;
		this.draftDate = draftDate;
		this.secret = secret;
		this.urgency = urgency;
		this.drafter = drafter;
		this.draftVerification = draftVerification;
		this.subject = subject;
		this.employer = employer;
		this.report = report;
		this.copy = copy;
		this.printDate = printDate;
		this.remark = remark;
		this.state = state;
		this.text = text;
		this.attachment = attachment;
		this.procedures = procedures;
		this.examineView = examineView;
		this.readView = readView;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDraftDate() {
		return draftDate;
	}
	public void setDraftDate(String draftDate) {
		this.draftDate = draftDate;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	public String getDrafter() {
		return drafter;
	}
	public void setDrafter(String drafter) {
		this.drafter = drafter;
	}
	public String getDraftVerification() {
		return draftVerification;
	}
	public void setDraftVerification(String draftVerification) {
		this.draftVerification = draftVerification;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getCopy() {
		return copy;
	}
	public void setCopy(String copy) {
		this.copy = copy;
	}
	public String getPrintDate() {
		return printDate;
	}
	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Map<String, String> getAttachment() {
		return attachment;
	}
	public void setAttachment(Map<String, String> attachment) {
		this.attachment = attachment;
	}
	public List<Procedure> getProcedures() {
		return procedures;
	}
	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}
	public List<View> getExamineView() {
		return examineView;
	}
	public void setExamineView(List<View> examineView) {
		this.examineView = examineView;
	}
	public List<View> getReadView() {
		return readView;
	}
	public void setReadView(List<View> readView) {
		this.readView = readView;
	}
	
	
	

}
