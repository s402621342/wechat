package controller;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.PostEntity;
import net.sf.json.JSONObject;
import service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/post", method = { RequestMethod.GET, RequestMethod.POST })
	public 	@ResponseBody String login(HttpServletRequest request,
			Map<String, Object> map,HttpServletResponse response){
		try{
			request.setCharacterEncoding("utf-8");
		}catch(Exception e){
			
		}
		try{
			String postItem=request.getParameter("PostItem");
			try{
				postItem=URLDecoder.decode(postItem, "utf-8");
			}catch(Exception e){
				
			}
			PostEntity postEntity=postService.analysis(postItem);
			postService.post(postEntity);
			map.put("success", "true");

		}catch(Exception e){
			e.printStackTrace();
			map.put("success", "false");
		}
		return JSONObject.fromObject(map).toString();
	}
}
