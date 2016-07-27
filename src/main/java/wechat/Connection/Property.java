package wechat.Connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Property {
	
	private static Properties getProperties(){
		Properties properties=new Properties();
		try{
			String path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
			InputStream fileInputStream=new FileInputStream(path+"wechat/wechat.properties");
			properties.load(fileInputStream);
		}catch(Exception e){

		}
		return properties;
	}
	
	
	public static String getAppID(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("appID");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getAppSecret(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("appsecret");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getLoginUri(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("loginuri");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getLogUri(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("loguri");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getCheckIDUri(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("checkiduri");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getTemplateID(){
		try{			
			Properties properties=getProperties();
			return properties.getProperty("template");
		}catch(Exception e){
			return "";
		}
		
	}
}
