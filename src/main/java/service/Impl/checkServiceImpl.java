package service.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.PathDAO;
import entity.OutLine;
import entity.Tab;
import model.Path;
import service.CheckService;
import wechat.HttpHelp;
@Service
public class CheckServiceImpl implements CheckService{
	@Autowired
	private PathDAO propertyDAO;

	public List<OutLine> getOutLines(Cookie[] cookies,String type) {
		// TODO Auto-generated method stub
		Path property=propertyDAO.getByCode("list");
		String url=property.getPath();
		url=url.replace("{0}", type);
		url=url.replace("{1}", "");
		url=url.replace("{2}", "0");				//暂时只有第一页
		url=url.replace("{3}", "10");
		url=url.replace("{4}", "");
		String cookieStr="";
		for(int i=0;i<cookies.length;i++){
			if(i!=0){
				cookieStr+=";";
			}
			cookieStr+=cookies[i].getName()+"="+cookies[i].getValue();
		}
		String response=HttpHelp.getResponseByCookie(url, "", cookieStr);
		List<OutLine> outLines=new ArrayList<>();
		Document document=Jsoup.parse(response);
		Elements elements=document.select("listitem");
		for(Element element:elements){
			String id=element.select("itemid").text();
			String title=element.select("title").text();
			String field1=element.select("field1").text();
			String field2=element.select("field2").text();
			String field3=element.select("field3").text();
			Long canopen=Long.parseLong(element.select("canopen").text());
			outLines.add(new OutLine(id, title, field3, field1, field2, canopen, type));
		}
		return outLines;
	}

	@Override
	public List<Tab> getTabs(Cookie[] cookies) {
		// TODO Auto-generated method stub
		List<Tab> tabs=new ArrayList<Tab>();
		Path property=propertyDAO.getByCode("tab");
		String url=property.getPath();
		String cookieStr="";
		for(int i=0;i<cookies.length;i++){
			if(i!=0){
				cookieStr+=";";
			}
			cookieStr+=cookies[i].getName()+"="+cookies[i].getValue();
		}
		String response=HttpHelp.getResponseByCookie(url, "", cookieStr);
		
		Document document=Jsoup.parse(response);
		Elements elements=document.select("tab");
		property=propertyDAO.getByCode("notification");
		url=property.getPath();
		response=HttpHelp.getResponseByCookie(url, "", cookieStr);
		Document document2=Jsoup.parse(response);
		for(Element element:elements){
			String id=element.attr("id");
			long count=0;
			try{
				count=Long.parseLong(document2.getElementById(id).attr("count"));
			}catch(Exception e){
				
			}
			String name=element.attr("title");
			tabs.add(new Tab(id, name, count));
		}
		
		Collections.sort(tabs);
		return tabs;
	}

}
