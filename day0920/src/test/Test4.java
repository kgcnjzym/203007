package test;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 使用SAX解析XML文档
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月20日]
 * @since V1.00
 */
public class Test4
{
    public static void main(String[] args)
    {
        //1.工厂模式创建SAXParser
        SAXParserFactory factory=null;
        SAXParser parser=null;
        MyOrderHandler handler=null;
        InputStream is=null;
        
        try {
            factory=SAXParserFactory.newInstance();
            parser=factory.newSAXParser();
            handler=new MyOrderHandler("124-AE");
            is=Test4.class.getClassLoader().getResourceAsStream("order.xml");
            
            //解析
            parser.parse(is, handler);
            System.out.println("result="+handler.getResult());
            
        }catch(Exception ex) {
            System.out.println(ex);
        }
        finally {
            try
            {
                is.close();
            }
            catch (Exception e)
            {}
        }
    }
    
}
