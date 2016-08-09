package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Property;
import net.sf.json.JSONObject;
import service.PropertyService;

@Controller
public class ConfigController {
	private static final String CONFIG = "config";
	@Autowired
	private PropertyService propertyService;

	@RequestMapping(value = "/config", method = { RequestMethod.GET, RequestMethod.POST })
	public String config(HttpServletRequest request, Map<String, Object> map) {
		List<Property> properties = propertyService.getAll();
		map.put("properties", properties);
		return CONFIG;
	}

	@RequestMapping(value = "/submitConfig", method = { RequestMethod.GET, RequestMethod.POST })
	public String submitConfig(HttpServletRequest request, Map<String, Object> map) {
		try {
			String name = request.getParameter("name");
			String code = request.getParameter("code");
			String param = request.getParameter("param");
			String path = request.getParameter("path");
			Property property = new Property();
			property.setCode(code);
			property.setName(name);
			property.setParam(param);
			property.setPath(path);
			map.put("success", "true");
			propertyService.add(property);
		} catch (Exception e) {
			map.put("success", "false");
		}
		return JSONObject.fromObject(map).toString();
	}

	@RequestMapping(value = "/delConfig", method = { RequestMethod.GET, RequestMethod.POST })
	public String delConfig(HttpServletRequest request, Map<String, Object> map) {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			Property property = new Property();
			property.setId(id);
			map.put("success", "true");
			propertyService.delete(property);
		} catch (Exception e) {
			map.put("success", "false");
		}
		return JSONObject.fromObject(map).toString();
	}

	@RequestMapping(value = "/updateConfig", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateConfig(HttpServletRequest request, Map<String, Object> map) {
		try {
			String name = request.getParameter("name");
			String code = request.getParameter("code");
			String param = request.getParameter("param");
			String path = request.getParameter("path");
			Property property = new Property();
			String id = request.getParameter("id");
			property.setId(Long.parseLong(id));

			property.setCode(code);
			property.setName(name);
			property.setParam(param);
			property.setPath(path);
			map.put("success", "true");
			propertyService.update(property);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", "false");
		}
		return JSONObject.fromObject(map).toString();
	}
}
