package test;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * XML简单解析示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月20日]
 * @since V1.00
 */
public class Test1
{
    public static void main(String[] args)
    {
        // 1.创建DocumentBuilderFactory
        DocumentBuilderFactory factory=null;
        // 2.创建DocumentBuilder
        DocumentBuilder builder=null;
        // 3.创建xml文档的输入流
        InputStream is=null;
        // 4.使用DocumentBuilder解析得到Document
        Document doc=null;
        // 5.根据xml文档结构读取内容
        
        try {
            factory=DocumentBuilderFactory.newInstance();
            builder=factory.newDocumentBuilder();
            is=Test1.class.getClassLoader().getResourceAsStream("order.xml");
            doc=builder.parse(is);
            //5.1读取根元素
            Element root=doc.getDocumentElement();
//            System.out.println(root.getNodeName());
            //5.2读取子元素
            //5.2.1读取子节点(所有类型子节点)
//            NodeList list=root.getChildNodes();
//            for(int i=0;i<list.getLength();i++) {
//                Node node=list.item(i);
                  //需要判断节点类型
//                if(node instanceof Element) {
//                    Element sub=(Element)node;
//                    System.out.println(sub.getAttribute("name"));
//                }
//            }
//            System.out.println(list.getLength());
            //5.2.2读取“子”元素（含孙级元素）
            NodeList list=root.getElementsByTagName("comment");
            for(int i=0;i<list.getLength();i++) {
                Element sub=(Element)list.item(i);
                //需要判断元素的父元素
                if(sub.getParentNode()==root) {
                    System.out.println(sub.getChildNodes().item(0).getNodeValue());
                }
                
            }
//            System.out.println(list.getLength());
            
                
        }
        catch(Exception ex) {
            
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
