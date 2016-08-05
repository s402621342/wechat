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
	public static String getDetailUri(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("detailuri");
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
	public static String getLoginInterface(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("loginInterface");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getTabInterface(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("tabInterface");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getNotificationInterface(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("notificationInterface");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getListInterface(){
		try{			
			Properties properties=getProperties();
			return properties.getProperty("listInterface");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getDetailInterface(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("detailInterface");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getSubmitInterface(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("submitInterface");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getDepartmentInterface(){
		try{
			Properties properties=getProperties();
			return properties.getProperty("departmentInterface");
		}catch(Exception e){
			return "";
		}
		
	}
	public static String getUserInterface(){
		try{			
			Properties properties=getProperties();
			return properties.getProperty("userListInterface");
		}catch(Exception e){
			return "";
		}
		
	}
	
}
