package test;

import java.io.InputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * 使用jdom解析XML：读取
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月20日]
 * @since V1.00
 */
public class Test5
{
    public static void main(String[] args)
    {
        SAXBuilder builder=new SAXBuilder();
        Document doc=null;
        InputStream is=null;
        try {
            is=Test5.class.getClassLoader().getResourceAsStream("order.xml");
            doc=builder.build(is);
            Element root=doc.getRootElement();
            List lst=root.getChildren();
            System.out.println(lst.size());
//            List lst=root.getChildren("Brand");
//            for(Object sub:lst) {
//                Element elm=(Element)sub;
//                System.out.println(elm.getAttributeValue("name"));
//                List types=elm.getChildren("Type");
//                for(Object obj:types) {
//                    Element em=(Element)obj;
//                    System.out.println("\t"+em.getAttributeValue("name"));
//                }
//            }
        }
        catch(Exception ex) {
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
