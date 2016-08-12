package service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.InfoDAO;
import DAO.UserDAO;
import entity.PostEntity;
import model.User;
import net.sf.json.JSONObject;
import service.PostService;
import service.WechatService;
import wechat.HttpHelp;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private InfoDAO infoDao;
	
	@Autowired
	private WechatService wechatService;
	
	@Override
	public String post(PostEntity entity) {
		// TODO Auto-generated method stub
		String result="";
		if("1".equals(infoDao.getbyName("radio").getValue())){				//如果进行推送
			
		
		String posturl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + wechatService.getToken();
		String topcolor = "#FF0000";
		String template_id = infoDao.getbyName("template").getValue();
		String color = "#173177";
		String detailUri=infoDao.getbyName("wechat").getValue()+"/toDetail";
		String redirect_uri = detailUri + "?type=" + entity.getType() + "&id=" + entity.getId();
		try {
			redirect_uri = java.net.URLEncoder.encode(redirect_uri, "utf-8");
		} catch (Exception e) {

		}
		String appID=infoDao.getbyName("appID").getValue();
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appID
				+ "&redirect_uri=" + redirect_uri + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";

		// 构建JSON,准备进行推送
		JSONObject data = new JSONObject();
		JSONObject object = new JSONObject();
		object.put("value", entity.getTitle());
		object.put("color", color);
		data.put("title", object);
		object.clear();
		object.put("value", entity.getAutor());
		object.put("color", color);
		data.put("autor", object);
		object.clear();
		object.put("value", entity.getDate());
		object.put("color", color);
		data.put("date", object);
		object.clear();
		object.put("value", entity.getState());
		object.put("color", color);
		data.put("state", object);

		JSONObject finalObject = new JSONObject();
		List<String> usernames = entity.getUsername();
		for (String username : usernames) {
			List<User> users = userDAO.getUserByName(username);
			for(User user:users){
				finalObject.put("touser", user.getId());
				finalObject.put("url", url);
				finalObject.put("template_id", template_id);
				finalObject.put("topcolor", topcolor);
				finalObject.put("data", data);
				result=HttpHelp.createhttpClient(posturl, finalObject.toString());
			}
		}
		}else{
		}
		return result;
	}

	@Override
	public PostEntity analysis(String PostItem) {
		// TODO Auto-generated method stub
		Document document = Jsoup.parse(PostItem);
		List<String> usernames = new ArrayList<>();
		String title = "";
		String msgid = "";
		String date = "";
		String autor = "";
		String state = "";
		String type = "";
		long canopen = 1;
		Elements elements = document.getElementsByAttributeValue("name", "username");
		if (elements.size() > 0) {
			String username = elements.get(0).html();
			String[] uStrings = username.split(";");
			for (int i = 0; i < uStrings.length; i++) {
				usernames.add(uStrings[i]);
			}
		}
		elements = document.getElementsByAttributeValue("name", "title");
		if (elements.size() > 0) {
			title = elements.get(0).html();
		}
		elements = document.getElementsByAttributeValue("name", "msgid");
		if (elements.size() > 0) {
			msgid = elements.get(0).html();
		}
		elements = document.getElementsByAttributeValue("name", "date");
		if (elements.size() > 0) {
			date = elements.get(0).html();
		}
		elements = document.getElementsByAttributeValue("name", "autor");
		if (elements.size() > 0) {
			autor = elements.get(0).html();
		}
		elements = document.getElementsByAttributeValue("name", "state");
		if (elements.size() > 0) {
			state = elements.get(0).html();
		}
		elements = document.getElementsByAttributeValue("name", "type");
		if (elements.size() > 0) {
			type = elements.get(0).html();
		}
		elements = document.getElementsByAttributeValue("name", "canopen");
		if (elements.size() > 0) {
			canopen = Long.parseLong(elements.get(0).html());
		}

		return new PostEntity(usernames, msgid, title, date, autor, state, canopen, type);
	}

}
