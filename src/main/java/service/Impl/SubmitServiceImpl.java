package service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import entity.Operation;
import net.sf.json.JSONArray;
import service.SubmitService;
import wechat.Connection.HttpHelp;

@Service
public class SubmitServiceImpl implements SubmitService {

	@Override
	public List<Operation> getOperation(Cookie[] cookies, String type, String id) {
		// TODO Auto-generated method stub
		String url="http://shqingyuan.f3322.net:81/xsgs/api.nsf/detail?openagent&type="+type+"&msgid="+id;
		String cookieStr="";
		for(int i=0;i<cookies.length;i++){
			if(i!=0){
				cookieStr+=";";
			}
			cookieStr+=cookies[i].getName()+"="+cookies[i].getValue();
		}
		List<Operation> operations=new ArrayList<>();
		
		String response=HttpHelp.getResponseByCookie(url, "", cookieStr);
		Document document=Jsoup.parse(response);
		Elements elements=document.select("operation");
		elements=elements.select("table");
		for(Element element:elements){

			String actionnum="";
			String nextstepusername="";
			String nextnode="";
			String actionname="";
			boolean fieldapproval=false;
			String documentid="";
			String checkdate="";
			boolean multi=false;
			List<String> options=new ArrayList<>();
			boolean hasOptions=false;
			
			
			Elements elements2=element.getElementsByAttributeValue("name", "actionnum");
			if (elements2.size()>0) {
				actionnum=elements2.get(0).attr("value");
				actionname=elements2.get(0).attr("title");
			}
			elements2=element.getElementsByAttributeValue("name", "nextnode");
			if (elements2.size()>0) {
				nextnode=elements2.get(0).attr("value");
			}
			elements2=element.getElementsByAttributeValue("name", "fieldapproval");
			if (elements2.size()>0) {
				fieldapproval=true;
			}
			elements2=element.getElementsByAttributeValue("name", "actionname");
			if (elements2.size()>0) {
				actionname=elements2.get(0).attr("value");
			}
			elements2=element.getElementsByAttributeValue("name", "documentid");
			if (elements2.size()>0) {
				documentid=elements2.get(0).attr("value");
			}
			elements2=element.getElementsByAttributeValue("name", "checkdate");
			if (elements2.size()>0) {
				checkdate=elements2.get(0).attr("value");
			}
			elements2=element.select("user");
			if(elements2.size()>0){
				hasOptions=true;
				Element element2=elements2.get(0);
				multi=element2.attr("multi").equals("true");
				elements2=element2.select("option");
				for(Element element3:elements2){
					options.add(element3.attr("value"));
				}
			}
			operations.add(new Operation(actionnum, nextstepusername, nextnode, actionname, fieldapproval, documentid, checkdate,hasOptions, options, multi));
		}
		return operations;
	}

}
