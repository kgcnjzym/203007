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
public class MyOrderHandler extends DefaultHandler
{
    private String result;
    
    private boolean found;
    private boolean exact;
    
    private String condition;
    
    public MyOrderHandler(String condition) {
        this.condition=condition;
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException
    {
        if("item".equals(qName) &&
            attributes.getValue("partNum").equals(condition)) {
            found=true;
        }
        if(found && "productName".equals(qName)) {
            exact=true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
        throws SAXException
    {
        if(exact) {
            result=new String(ch,start,length).trim();
            exact=false;
            found=false;
        }
    }

    public String getResult()
    {
        return result;
    }

   
    
}
