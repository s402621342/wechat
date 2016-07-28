package wechat;





import entity.ListXML;
import entity.TransferXML;

public class Main 
{
	
    public static void main( String[] args )
    {
//       InitButton initButton=new InitButton();
//    	System.out.print(initButton.initButtons());
//    	System.out.println(Post.post("o0CJjwVyXn36-uAO1esNQQYQFX84", new OutLine(1, 
//    	"关于同意中共上海先进半导体制造股份有限公司委员会增补委员选举结果的批复","2015-12-21 14:38", "唐隆昱", "审批中")));
    	String string="<root><list><listitem><itemid>A351356E0F551A1D48257DFE0015C1BA</itemid><title>asdasdasdas</title><field1>类型：收文        来文单位：上海</field1><field2>状态：综合处中转</field2><field3>2015-04-15</field3><canopen>1</canopen></listitem><listitem><itemid>B182AE891E6A011648257F3A00217738</itemid><title>1111</title><field1>类型：收文        来文单位：</field1><field2>状态：综合处中转</field2><field3>2016-01-14</field3><canopen>1</canopen></listitem></list></root>";
    	ListXML xml= TransferXML.toBean(string, ListXML.class);
    }
    
    
    

    
    
    
	
}
