package service.Impl;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.PropertyDAO;
import entity.Operation;
import entity.SubmitEntity;
import model.Property;
import service.SubmitService;
import wechat.Connection.HttpHelp;

@Service
public class SubmitServiceImpl implements SubmitService {
	@Autowired
	private PropertyDAO propertyDAO;
	@Override
	public List<Operation> getOperation(Cookie[] cookies, String type, String id) {
		// TODO Auto-generated method stub
		
		Property property=propertyDAO.getByCode("detail");
		String url=property.getPath();
		url=url.replace("{0}", type);
		url=url.replace("{1}", id);
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
			elements2=element.getElementsByAttributeValue("name", "actionname");
			if (elements2.size()>0) {
				actionname=elements2.get(0).attr("value");
			}
			elements2=element.getElementsByAttributeValue("name", "nextnode");
			if (elements2.size()>0) {
				if(actionname.equals("")){
					actionname=elements2.get(0).attr("title");
				}
				nextnode=elements2.get(0).attr("value");
			}
			elements2=element.getElementsByAttributeValue("name", "fieldapproval");
			if (elements2.size()>0) {
				fieldapproval=true;
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

	@Override
	public Map<String, String> submit(Cookie[] cookies, SubmitEntity entity,String type,String id) {
		// TODO Auto-generated method stub
		Property property=propertyDAO.getByCode("submit");
		String url=property.getPath();
		String cookieStr="";
		for(int i=0;i<cookies.length;i++){
			if(i!=0){
				cookieStr+=";";
			}
			cookieStr+=cookies[i].getName()+"="+cookies[i].getValue();
		}
		String submitResultItem="<?xml version=\"1.0\" encoding=\"utf-8\"?><root><form><item name=\"nextnode\">"+entity.getNextnode()+"</item>"+
			     "<item name=\"fieldapproval\">"+entity.getFieldapproval()+"</item>"+
			     "<item name=\"documentid\">"+entity.getDocumentid()+"</item>"+
			     "<item name=\"actionname\">"+entity.getActionname()+"</item>"+
			     "<item name=\"checkdate\">"+entity.getCheckdate()+"</item>"+
			     "<item name=\"nextstepusername\">"+entity.getNextstepusername()+"</item>"+
								"</form></root>";
		try{
			submitResultItem=URLEncoder.encode(submitResultItem, "utf-8");
			submitResultItem=URLEncoder.encode(submitResultItem, "utf-8");
		}catch(Exception e){
			
		}
		String param=property.getParam();
		param=param.replace("{0}", submitResultItem);
		param=param.replace("{1}", type);
		param=param.replace("{2}", id);
	
		String response=HttpHelp.getResponseByCookie(url, param, cookieStr);
		Document document=Jsoup.parse(response);
		Elements elements=document.select("result");
		String result=elements.get(0).html();
		elements=document.select("message");
		String message=elements.get(0).html();
		Map<String, String> map=new HashMap<>();
		try{
			message=URLEncoder.encode(message, "utf-8");
		}catch(Exception e){
			
		}
		map.put("result", result);
		map.put("message", message);
		return map;
	}

}
