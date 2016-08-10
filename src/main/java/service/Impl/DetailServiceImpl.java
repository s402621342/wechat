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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.PathDAO;
import entity.Information;
import entity.OtherInfo;
import model.Path;
import service.DetailService;
import wechat.HttpHelp;
@Service
public class DetailServiceImpl implements DetailService {
	@Autowired
	private PathDAO propertyDAO;

	@Override
	public Information getInformation(Cookie[] cookies, String type, String id) {
		// TODO Auto-generated method stub
		Path property=propertyDAO.getByCode("detail");
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
		String response=HttpHelp.getResponseByCookie(url, "", cookieStr);
		Document document=Jsoup.parse(response);
		Elements elements=document.select("form");
		
		Map<String, Map<String, String>> basicInfo=new HashMap<>();
		Map<String, Map<String, String>> attachment=new HashMap<>();
		Map<String, List<OtherInfo>> otherInfo=new HashMap<>();	
		boolean canOperate;
		if(elements.size()>0){
			elements=elements.select("table");
			for(Element element:elements){
				if(element.attr("columns").equals("2")){				//基础信息
					Map<String, String> map=new HashMap<>();
					String title=element.attr("title");
					Elements elements2=element.select("td");
					for(int i=0;i<elements2.size()-1;i+=2){
						map.put(elements2.get(i).text(),elements2.get(i+1).text() );
					}
					basicInfo.put(title, map);
				}else if(element.attr("columns").equals("1")){			//其他信息
					String title=element.attr("title");
					Elements elements2=element.select("input");
					if(elements2.size()>0){						//附件正文等以input开头
						Map<String, String> map=new HashMap<>();
						for(Element element2:elements2){					
							map.put(element2.attr("title"), element2.attr("value"));
						}
						attachment.put(title, map);
					}
					elements2=element.select("td");
					if(elements2.size()>0&&elements2.get(0).text().startsWith("(html)")){			//意见、流程等
						List<OtherInfo> otherInfos=new ArrayList<>();
						Document document2=Jsoup.parse(elements2.get(0).text());
						Elements elements3=document2.select("tr");
						List<String> tableTitle=new ArrayList<>();
						for(int i=0;i<elements3.size();i++){
							if(i==0){				//表格的头
								Elements elements4=elements3.get(i).select("td");
								for(Element element2:elements4){
									tableTitle.add(element2.text());
								}
							}else{
								Map<String, Map<String, Boolean>> info=new HashMap<>();
								Elements elements4=elements3.get(i).select("td");			//表格内容
								for(int j=0;j<elements4.size()&&j<tableTitle.size();j++){
									Map<String, Boolean> src=new HashMap<>();
									String in;
									Boolean isImg=elements4.get(j).select("img").size()>0;
									if(isImg){
										in=elements4.get(j).select("img").get(0).attr("src");
									}else{
										in=elements4.get(j).text();
									}
									src.put(in, isImg);
									info.put(tableTitle.get(j),src);
								}
								otherInfos.add(new OtherInfo(info));
								otherInfo.put(title, otherInfos);
							}
						}
						
					}
				}
			}
		}
		document=Jsoup.parse(response);
		elements=document.select("operation");
		canOperate=(elements.size()>=1);

		return new Information(id, type, canOperate, basicInfo, attachment, otherInfo);
	}
}
