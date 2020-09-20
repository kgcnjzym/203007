package test;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/**
 * 使用jdom解析XML：写入
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月20日]
 * @since V1.00
 */
public class Test6
{
    public static void main(String[] args)
    {
        Document doc=null;
        OutputStream os=null;
        XMLOutputter outter=null;
        try {
            doc=new Document();
            Element root=new Element("root");
            doc.addContent(root);
            Element sub=new Element("sub");
            sub.setAttribute("name","test1");
            sub.setText("this is sub1");
            root.addContent(sub);
            sub=new Element("sub");
            sub.setAttribute("name","test2");
            sub.setText("this is sub2");
            root.addContent(sub);
            //输出
            os=new FileOutputStream("resources/t2.xml");
            outter=new XMLOutputter();
            outter.output(doc, os);
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
