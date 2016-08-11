package wechat;

public class Main 
{
	
    public static void main( String[] args )
    {
    	String type="swdb";
    	String username="高进";
    	String title="测试";
    	String msgid="082A3FBB4E1FC90148257EF500075FEE";
    	String date="2015年4月3日";
    	String autor="韩";
    	String state="审核中";
    	String PostItem="<?xml version=\"1.0\" encoding=\"utf-8\"?><root><form><item name=\"username\">"+username+"</item>"+
			     "<item name=\"title\">"+title+"</item>"+
			     "<item name=\"msgid\">"+msgid+"</item>"+
			     "<item name=\"date\">"+date+"</item>"+
			     "<item name=\"autor\">"+autor+"</item>"+
			     "<item name=\"state\">"+state+"</item>"+
			     "<item name=\"type\">"+type+"</item>"+
								"</form></root>";
    	
    	try{
    		PostItem=java.net.URLEncoder.encode(PostItem,"utf-8");
    		PostItem=java.net.URLEncoder.encode(PostItem,"utf-8");
    	}catch(Exception e){
    		
    	}
    	String url="http://192.168.2.81:8080/wechat/post?PostItem="+PostItem;
    	System.out.println(HttpHelp.createhttpClient(url,""));
    }
    
    
    

    
    
    
	
}
