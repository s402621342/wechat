package wechat.Button;

import java.util.ArrayList;
import java.util.List;


import net.sf.json.JSONObject;
import wechat.Connection.HttpHelp;
import wechat.Connection.Property;
import wechat.Connection.Token;

public class InitButton {

    
    public String initButtons(){
    	System.out.println(deleteButton());
    	String uri="";
    	try{
    		uri=java.net.URLEncoder.encode(Property.getLoginUri(),"utf-8");
    	}catch(Exception e){
    		
    	}
    	Button button1=new Button("view", "我的审批", "check", "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+Property.getAppID()+"&redirect_uri="+uri+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
    	List<Button> buttonlist=new ArrayList<Button>();
//    	Button button2=new Button("view", "审批记录", "log", Property.getLogUri());
    	buttonlist.add(button1);
//    	buttonlist.add(button2);
    	Buttons buttons=new Buttons(buttonlist);
    	return addButton(buttons);
    	
    }
    
    
    public String deleteButton(){
    	String url="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="+Token.getToken();
    	return HttpHelp.createhttpClient(url, "");
    }
    
    public String addButton(Buttons button){
    	JSONObject jsonObject=JSONObject.fromObject(button);
    	String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+Token.getToken();
    	String body=jsonObject.toString();
//    	System.out.println(body);
    	return HttpHelp.createhttpClient(url, body);
    	
    }
}
