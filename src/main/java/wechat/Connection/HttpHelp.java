package wechat.Connection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class HttpHelp {
	public static String createhttpClient(String url,String param) {
		  HttpClient client=new HttpClient();
	  	  String response = null;
	  	  PostMethod postMethod = new PostMethod(url);
	  	  RequestEntity entity=new StringRequestEntity(param);
	  	  postMethod.setRequestEntity(entity);
	  	  try{
	  		client.executeMethod(postMethod);
	  	   response = new String(postMethod.getResponseBodyAsString()
	  	     .getBytes("ISO-8859-1"), "utf-8");
	  	     //这里要注意下 gb2312要和你抓取网页的编码要一样
	  	  } catch (Exception e) {
	  	   e.printStackTrace();
	  	  }
	  	  
	  	  return response;
	  	}
}