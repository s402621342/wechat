package entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("root")
public class ListXML {
	@XStreamAlias("list")
	private List<OutLine> outline;

	public List<OutLine> getOutline() {
		return outline;
	}

	public void setOutline(List<OutLine> outline) {
		this.outline = outline;
	}
	
}
