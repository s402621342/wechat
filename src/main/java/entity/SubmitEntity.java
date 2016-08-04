package entity;

public class SubmitEntity {
	String nextnode;
	String fieldapproval;
	String documentid;
	String actionname;
	String checkdate;
	String nextstepusername;
	public SubmitEntity(String nextnode, String fieldapproval, String documentid, String actionname, String checkdate,
			String nextstepusername) {
		super();
		this.nextnode = nextnode;
		this.fieldapproval = fieldapproval;
		this.documentid = documentid;
		this.actionname = actionname;
		this.checkdate = checkdate;
		this.nextstepusername = nextstepusername;
	}
	public String getNextnode() {
		return nextnode;
	}
	public void setNextnode(String nextnode) {
		this.nextnode = nextnode;
	}
	public String getFieldapproval() {
		return fieldapproval;
	}
	public void setFieldapproval(String fieldapproval) {
		this.fieldapproval = fieldapproval;
	}
	public String getDocumentid() {
		return documentid;
	}
	public void setDocumentid(String documentid) {
		this.documentid = documentid;
	}
	public String getActionname() {
		return actionname;
	}
	public void setActionname(String actionname) {
		this.actionname = actionname;
	}
	public String getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}
	public String getNextstepusername() {
		return nextstepusername;
	}
	public void setNextstepusername(String nextstepusername) {
		this.nextstepusername = nextstepusername;
	}
	
	
}
