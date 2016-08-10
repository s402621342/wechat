package service.Impl;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.InfoDAO;
import exception.InvalidUserException;
import service.LoginService;
import wechat.HttpHelp;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private InfoDAO infoDao;
	
	@Override
	public Cookie login(String username, String password) throws InvalidUserException{
		// TODO Auto-generated method stub
		String url=infoDao.getbyName("autopath").getValue();
		String param=infoDao.getbyName("autoparam").getValue();
		param=param.replace("{0}", username);
		param=param.replace("{1}", password);
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
