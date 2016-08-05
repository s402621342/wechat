package service.Impl;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Service;

import exception.InvalidUserException;
import service.LoginService;
import wechat.Connection.HttpHelp;
import wechat.Connection.Property;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public Cookie login(String username, String password) throws InvalidUserException{
		// TODO Auto-generated method stub
		String url=Property.getLoginInterface();
		String param="username="+username+"&password="+password+"";
		try{
			String response=HttpHelp.getOriginCookie(url, param);
		
		String name="DomAuthSessId";
		String[] strings=response.split(";");
		String value="";
		for(int i=0;i<strings.length;i++){
			if(strings[i].contains(name)){
				value=strings[i].substring(name.length()+1, strings[i].length());
				break;
			}
		}
		Cookie cookie=new Cookie(name, value);
		return cookie;
		}catch(NullPointerException e){
			throw new InvalidUserException();
		}
	}

}
