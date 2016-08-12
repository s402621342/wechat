package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Info;
import model.Path;
import net.sf.json.JSONObject;
import service.InfoService;
import service.PathService;
import service.WechatService;

@Controller
public class ConfigController {
	private static final String CONFIG = "config";
	@Autowired
	private PathService pathService;
	
	@Autowired
	private InfoService infoService;
	
	@Autowired 
	private WechatService wechatService;

	@RequestMapping(value = "/config", method = { RequestMethod.GET, RequestMethod.POST })
	public String config(HttpServletRequest request, Map<String, Object> map) {
		String type="gw";		//type暂时默认为gw
		List<Path> properties = pathService.getAllByType(type);
		List<Info> infos=infoService.getAllByType(type);
		for(Info info:infos){
			map.put(info.getName(), info.getValue());
		}
		map.put("properties", properties);
		map.put("type", type);
		return CONFIG;
	}

	@RequestMapping(value = "/submitConfig", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String submitConfig(HttpServletRequest request, Map<String, Object> map) {
		try {
			String name = request.getParameter("name");
			String code = request.getParameter("code");
			String param = request.getParameter("param");
			String path = request.getParameter("path");
			String type=request.getParameter("type");
			Path property = new Path();
			property.setCode(code);
			property.setName(name);
			property.setParam(param);
			property.setPath(path);
			property.setType(type);
			map.put("success", "true");
			pathService.add(property);
		} catch (Exception e) {
			map.put("success", "false");
		}
		return JSONObject.fromObject(map).toString();
	}

	@RequestMapping(value = "/delConfig", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String delConfig(HttpServletRequest request, Map<String, Object> map) {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			Path property = new Path();
			property.setId(id);
			map.put("success", "true");
			pathService.delete(property);
		} catch (Exception e) {
			map.put("success", "false");
		}
		return JSONObject.fromObject(map).toString();
	}

	@RequestMapping(value = "/updateConfig", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String updateConfig(HttpServletRequest request, Map<String, Object> map) {
		try {
			String name = request.getParameter("name");
			String code = request.getParameter("code");
			String param = request.getParameter("param");
			String path = request.getParameter("path");
			String type=request.getParameter("type");
			Path path2 = new Path();
			String id = request.getParameter("id");
			path2.setId(Long.parseLong(id));
			path2.setType(type);
			path2.setCode(code);
			path2.setName(name);
			path2.setParam(param);
			path2.setPath(path);
			map.put("success", "true");
			pathService.update(path2);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", "false");
		}
		return JSONObject.fromObject(map).toString();
	}
	
	@RequestMapping(value = "/updateBasic", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String updateBasic(HttpServletRequest request, Map<String, Object> map) {
		try {
			List<Info> infos=new ArrayList<>();
			String type=request.getParameter("type");
			String name="name";
			String value=request.getParameter(name);
			infos.add(new Info(name, value, type));
			name="remarks";
			value=request.getParameter(name);
			infos.add(new Info(name, value, type));
			name="authtype";
			value=request.getParameter(name);
			infos.add(new Info(name, value, type));
			name="cookies";
			value=request.getParameter(name);
			infos.add(new Info(name, value, type));
			name="autopath";
			value=request.getParameter(name);
			infos.add(new Info(name, value, type));
			name="autoparam";
			value=request.getParameter(name);
			infos.add(new Info(name, value, type));
			name="radio";
			value=request.getParameter(name);
			infos.add(new Info(name, value, type));
			name="wechat";
			value=request.getParameter(name);
			infos.add(new Info(name, value, type));
			name="appID";
			value=request.getParameter(name);
			infos.add(new Info(name, value, type));
			name="appsecret";
			value=request.getParameter(name);
			infos.add(new Info(name, value, type));
			name="template";
			value=request.getParameter(name);
			infos.add(new Info(name, value, type));
			infoService.update(infos);
			
			
			
			System.out.println(wechatService.initButtons());				//重新生成按钮
	    	
	    	
			map.put("success", "true");
		} catch (Exception e) {
			map.put("success", "false");
		}
		return JSONObject.fromObject(map).toString();
	}
}
