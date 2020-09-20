package test;

import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * XML简单创建示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月20日]
 * @since V1.00
 */
public class Test2
{
    public static void main(String[] args)
    {
        DocumentBuilderFactory factory=null;
        DocumentBuilder builder=null;
        // 创建xml文档的输出流
        OutputStream os=null;
        // 使用DocumentBuilder新建Document
        Document doc=null;
        // 创建传输器工厂
        TransformerFactory transFactory=null;
        // 创建传输器
        Transformer trans=null;
        // 创建DOM源DOMSource
        DOMSource source=null;
        // 创建输出目的地StreamResult
        StreamResult result=null;
        
        try {
            factory=DocumentBuilderFactory.newInstance();
            builder=factory.newDocumentBuilder();
            // 使用DocumentBuilder新建Document
            doc=builder.newDocument();
            //往doc中添加子元素、文本、属性等
            // 创建元素
            Element root=doc.createElement("root");
            // 添加到doc中，使其成为根元素
            doc.appendChild(root);
            // 创建元素
            Element sub=doc.createElement("sub");
            // 添加到root中，使其成为root的子元素
            root.appendChild(sub);
            // 给sub添加属性
            sub.setAttribute("name", "test");
            // 创建文本节点
            Text txt=doc.createTextNode("this is text");
            // 将文本节点添加到sub中
            sub.appendChild(txt);
            // 保存步骤
            // 1.创建传输器工厂
            transFactory=TransformerFactory.newInstance();
            // 2.创建传输器
            trans =transFactory.newTransformer();
            // 3.创建DOM源DOMSource
            source=new DOMSource(doc);
            // 4.创建输出目的地StreamResult
            os=new FileOutputStream("resources/t1.xml");
            result=new StreamResult(os);
            // 5.输出
            trans.transform(source, result);
            System.out.println("OK");
            
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
