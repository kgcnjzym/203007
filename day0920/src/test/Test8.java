package test;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * 使用dom4j解析XML：写入
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月20日]
 * @since V1.00
 */
public class Test8
{
    public static void main(String[] args)
    {
        OutputStream os=null;
        Document doc=null;
        XMLWriter writer=null;
        try {
            doc=DocumentHelper.createDocument();
            Element root=doc.addElement("root");
            Element sub=root.addElement("sub");
            sub.addAttribute("name", "sub1");
            sub.setText("this is sub1");
            sub=root.addElement("sub");
            sub.addAttribute("name", "sub2");
            sub.setText("this is sub2");
            //输出
            os=new FileOutputStream("resources/t3.xml");
            writer=new XMLWriter(os);
            writer.write(doc);
            System.out.println("ok");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        finally {
            try
            {
                os.close();
            }
            catch (Exception e)
            {}
        }
    }
    
}
