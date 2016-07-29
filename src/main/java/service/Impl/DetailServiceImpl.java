package service.Impl;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Service;

import entity.Information;
import service.DetailService;
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
		return null;
	}

}
