package wechat.Connection;

import entity.OutLine;
import net.sf.json.JSONObject;

public class Post {
	public static String post(String openid,OutLine outLine){
		String posturl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+Token.getToken();
		String topcolor="#FF0000";
		String template_id=Property.getTemplateID();
		String color="#173177";
		String url=Property.getCheckIDUri()+outLine.getId();
		
		//构建JSON
		JSONObject data=new JSONObject();
		JSONObject object=new JSONObject();
		object.put("value", outLine.getTitle());
		object.put("color", color);
		data.put("title", object);
		object.clear();
		object.put("value", outLine.getAutor());
		object.put("color", color);
		data.put("autor",object);
		object.clear();
		object.put("value", outLine.getDate());
		object.put("color", color);
		data.put("date",object);
		object.clear();
		object.put("value", outLine.getState());
		object.put("color", color)	;
		data.put("state",object);
		
		JSONObject finalObject=new JSONObject();
		finalObject.put("touser", openid);
		finalObject.put("url", url);
		finalObject.put("template_id", template_id);
		finalObject.put("topcolor", topcolor);
		finalObject.put("data", data);
		
		return HttpHelp.createhttpClient(posturl, finalObject.toString());
		
		
		
	}
}
