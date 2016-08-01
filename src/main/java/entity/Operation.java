package entity;

public class Operation {
	String actionnum;
	String nextstepusername;
	String nextnode;
	String actionname;
	boolean fieldapproval;
	String documentid;
	String checkdate;
	String  options;
	boolean multi;
	public Operation(String actionnum, String nextstepusername, String nextnode, String actionname,
			boolean fieldapproval, String documentid, String checkdate, String options, boolean multi) {
		super();
		this.actionnum = actionnum;
		this.nextstepusername = nextstepusername;
		this.nextnode = nextnode;
		this.actionname = actionname;
		this.fieldapproval = fieldapproval;
		this.documentid = documentid;
		this.checkdate = checkdate;
		this.options = options;
		this.multi = multi;
	}
	public String getActionnum() {
		return actionnum;
	}
	public void setActionnum(String actionnum) {
		this.actionnum = actionnum;
	}
	public String getNextstepusername() {
		return nextstepusername;
	}
	public void setNextstepusername(String nextstepusername) {
		this.nextstepusername = nextstepusername;
	}
	public String getNextnode() {
		return nextnode;
	}
	public void setNextnode(String nextnode) {
		this.nextnode = nextnode;
	}
	public String getActionname() {
		return actionname;
	}
	public void setActionname(String actionname) {
		this.actionname = actionname;
	}
	public boolean isFieldapproval() {
		return fieldapproval;
	}
	public void setFieldapproval(boolean fieldapproval) {
		this.fieldapproval = fieldapproval;
	}
	public String getDocumentid() {
		return documentid;
	}
	public void setDocumentid(String documentid) {
		this.documentid = documentid;
	}
	public String getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public boolean isMulti() {
		return multi;
	}
	public void setMulti(boolean multi) {
		this.multi = multi;
	}
	
	
	
}
