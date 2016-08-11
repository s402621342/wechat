package service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.InfoDAO;
import entity.Button;
import entity.Buttons;
import net.sf.json.JSONObject;
import service.WechatService;
import wechat.HttpHelp;
@Service
public class WechatServiceImpl implements WechatService {

	@Autowired
	private InfoDAO infoDao;
	
	@Override
	public String getToken() {
		// TODO Auto-generated method stub
		String appID =infoDao.getbyName("appID").getValue();
        String appsecret = infoDao.getbyName("appsecret").getValue();
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appsecret;
        String response=HttpHelp.createhttpClient(url,"");
        JSONObject json=JSONObject.fromObject(response);
        String ACCESS_TOKEN=json.get("access_token").toString();
        System.out.println(ACCESS_TOKEN);
        return ACCESS_TOKEN;
	}

	@Override
	public String getOpenID(String code) {
		// TODO Auto-generated method stub
		String appID =infoDao.getbyName("appID").getValue();
        String appsecret = infoDao.getbyName("appsecret").getValue();
		String uri="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appID+"&secret="+
        appsecret+"&code="+code+"&grant_type=authorization_code";
		String response=HttpHelp.createhttpClient(uri, "");
		JSONObject json=JSONObject.fromObject(response);
		String OpenID=json.get("openid").toString();
		return OpenID;
	}

	@Override
	public String initButtons() {
		// TODO Auto-generated method stub
		System.out.println(deleteButton());
    	String uri=infoDao.getbyName("wechat").getValue()+"/login";
    	try{
    		uri=java.net.URLEncoder.encode(uri,"utf-8");
    	}catch(Exception e){
    		
    	}
    	String appID=infoDao.getbyName("appID").getValue();
    	Button button1=new Button("view", "我的审批", "check", "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appID
    			+"&redirect_uri="+uri+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
    	List<Button> buttonlist=new ArrayList<Button>();
    	try{
    		uri=java.net.URLEncoder.encode(infoDao.getbyName("wechat").getValue()+"/settinglogin","utf-8");
    	}catch(Exception e){
    		
    	}
    	
    	Button button2=new Button("view", "个人设置", "setting", "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appID
    	+"&redirect_uri="+uri+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
    	buttonlist.add(button1);
    	buttonlist.add(button2);
    	Buttons buttons=new Buttons(buttonlist);
    	return addButton(buttons);
	}
	
	  private  String deleteButton(){
	    	String url="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="+getToken();
	    	return HttpHelp.createhttpClient(url, "");
	    }
	    
	    private  String addButton(Buttons button){
	    	JSONObject jsonObject=JSONObject.fromObject(button);
	    	String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+getToken();
	    	String body=jsonObject.toString();
	    	return HttpHelp.createhttpClient(url, body);
	    	
	    }

}
