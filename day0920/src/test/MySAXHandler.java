package test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 自定义SAX处理器
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月20日]
 * @since V1.00
 */
public class MySAXHandler extends DefaultHandler
{

    @Override
    public void startDocument()
        throws SAXException
    {
        System.out.println("startDocument");
    }

    @Override
    public void endDocument()
        throws SAXException
    {
        System.out.println("endDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException
    {
        System.out.print("<"+qName);
        for(int i=0;i<attributes.getLength();i++) {
            System.out.print(" "+attributes.getQName(i)
            +"=\""+attributes.getValue(i)+"\"");
        }
        System.out.println(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName)
        throws SAXException
    {
        System.out.println("</"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length)
        throws SAXException
    {
        String  str=new String(ch,start,length).trim();
        System.out.print(str);
    }
    
}
