package test;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

/**
 * 使用SAX解析XML文档
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月20日]
 * @since V1.00
 */
public class Test3
{
    public static void main(String[] args)
    {
        //1.工厂模式创建SAXParser
        SAXParserFactory factory=null;
        SAXParser parser=null;
        DefaultHandler handler=null;
        InputStream is=null;
        
        try {
            factory=SAXParserFactory.newInstance();
            parser=factory.newSAXParser();
            handler=new MySAXHandler();
            is=Test3.class.getClassLoader().getResourceAsStream("phone.xml");
            
            //解析
            parser.parse(is, handler);
            System.out.println("ok");
            
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
