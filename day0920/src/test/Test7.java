package test;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用dom4j解析XML：读取
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月20日]
 * @since V1.00
 */
public class Test7
{
    public static void main(String[] args)
    {
        InputStream is=null;
        SAXReader sax=null;
        Document doc=null;
        try {
            sax=new SAXReader();
            is=Test7.class.getClassLoader().getResourceAsStream("phone.xml");
            doc=sax.read(is);
            Element root=doc.getRootElement();
            List list=root.elements("Brand");
            for(Object obj:list) {
                Element sub=(Element)obj;
                System.out.println(sub.attributeValue("name"));
                Iterator itor=sub.elementIterator("Type");
                while(itor.hasNext()) {
                    Element elm=(Element)itor.next();
                    System.out.println("\t"+elm.attributeValue("name"));
                }
            }
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
