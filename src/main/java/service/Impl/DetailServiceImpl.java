package service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.wiring.BeanWiringInfo;
import org.springframework.stereotype.Service;

import entity.Information;
import entity.Procedure;
import entity.View;
import entity.ViewHead;
import service.DetailService;
import wechat.Connection.HttpHelp;
@Service
public class DetailServiceImpl implements DetailService {

	@Override
	public Information getInformation(Cookie[] cookies, String type, String id) {
		// TODO Auto-generated method stub
		String url="http://shqingyuan.f3322.net:81/xsgs/api.nsf/detail?openagent&type="+type+"&msgid="+id;
		String cookieStr="";
		for(int i=0;i<cookies.length;i++){
			if(i!=0){
				cookieStr+=";";
			}
			cookieStr+=cookies[i].getName()+"="+cookies[i].getValue();
		}
		String response=HttpHelp.getResponseByCookie(url, "", cookieStr);
		Document document=Jsoup.parse(response);
		
		Map<String, String> outline=new HashMap<>();
		Map<String, String> otherInfo=new HashMap<>();
		Map<String, String> attachment=new HashMap<>();
		Map<String, String> text=new HashMap<>();
		Map<ViewHead, List<View>> views=new HashMap<>();
		
		List<Procedure> procedures=new ArrayList<>();
		Elements elements=document.getElementsByAttributeValue("title", "概要");
		for(Element element:elements){
			Elements elements2=element.select("td");
			for(int i=0;i<elements2.size()-1;i+=2){
				outline.put(elements2.get(i).text(),elements2.get(i+1).text() );
			}
		}
		
		elements=document.getElementsByAttributeValue("title", "其他信息");
		for(Element element:elements){
			Elements elements2=element.select("td");
			for(int i=0;i<elements2.size()-1;i+=2){
				otherInfo.put(elements2.get(i).text(),elements2.get(i+1).text() );
			}
		}
		elements=document.getElementsByAttributeValue("title", "附件");
		for(Element element:elements){
			Elements elements2=element.select("tr");
			for(int i=0;i<elements2.size();i++){
				Elements elements3=elements2.select("input");
				for(int j=0;j<elements3.size();j++){
					attachment.put(elements3.get(j).attr("title"),elements2.get(j).attr("value") );
				}
			}
		}
		elements=document.getElementsByAttributeValue("title", "正文");
		for(Element element:elements){
			Elements elements2=element.select("tr");
			for(int i=0;i<elements2.size();i++){
				Elements elements3=elements2.select("input");
				for(int j=0;j<elements3.size();j++){
					text.put(elements3.get(j).attr("title"),elements2.get(j).attr("value") );
				}
			}
		}
		elements=document.getElementsByAttributeValue("title", "流程跟踪");
		for(Element element:elements){
			Elements elements2=element.select("tr");
			for(int i=0;i<elements2.size();i++){
				Elements elements3=elements2.select("td");
				Document document2=Jsoup.parse(elements3.get(0).text());
				elements3=document2.select("td");
				for(int j=5;j<elements3.size()-4;j+=5){
					procedures.add(new Procedure(elements3.get(j).text(), elements3.get(j+1).text(), elements3.get(j+2).text()
							, elements3.get(j+3).text(), elements3.get(j+4).text()));
				}
			}
		}
		
		elements=document.getElementsByAttributeValueEnding("title", "意见");
		for(Element element:elements){
			String title=element.attr("title");
			List<View> views2=new ArrayList<>();
			ViewHead viewHead=new ViewHead("意见", "审批人", "审批时间", "审批意见", "签名");
			Elements elements2=element.select("tr");
			for(int i=0;i<elements2.size();i++){
				Elements elements3=elements2.select("td");
				Document document2=Jsoup.parse(elements3.get(0).text());
				elements3=document2.select("td");
				if(elements3.size()>=4){
					viewHead=new ViewHead(title, elements3.get(0).text(), elements3.get(1).text(), 
							elements3.get(2).text(), elements3.get(3).text());
					
				}
				for(int j=4;j<elements3.size()-3;j+=4){
					views2.add(new View(elements3.get(j).text(), elements3.get(j+1).text(), elements3.get(j+2).text()
							, elements3.get(j+3).attr("src")));
				}
			}
			views.put(viewHead, views2);
		}
		
		
		return new Information(outline, otherInfo,attachment,text.size()>0,text,procedures,views);
	}

}
