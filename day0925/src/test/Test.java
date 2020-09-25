package test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.xt.entity.PhonePackage;
import com.xt.entity.Scene;
import com.xt.utils.XMLUtil;


public class Test
{
    
    public static void main(String[] args)
    {
        InputStream is=null;
        SAXBuilder builder=null;
        try {
            is=Test.class.getClassLoader().getResourceAsStream("Scene.xml");
            builder=new SAXBuilder();
            Document doc=builder.build(is);
            Element root=doc.getRootElement();
            List<Scene> lst=new ArrayList<>();
            List subs=root.getChildren("scene");
            for(Object obj:subs) {
                Scene pkg=XMLUtil.getObjectFromElement((Element)obj, Scene.class);
                lst.add(pkg);
            }
            System.out.println(lst);
            
        }
        catch(Exception ex) {
            ex.printStackTrace();
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
    
    public static void main1(String[] args)
    {
        InputStream is=null;
        SAXBuilder builder=null;
        try {
            is=Test.class.getClassLoader().getResourceAsStream("Package.xml");
            builder=new SAXBuilder();
            Document doc=builder.build(is);
            Element root=doc.getRootElement();
            List<PhonePackage> lst=new ArrayList<>();
            List subs=root.getChildren("package");
            for(Object obj:subs) {
                PhonePackage pkg=XMLUtil.getObjectFromElement((Element)obj, PhonePackage.class);
                lst.add(pkg);
            }
            System.out.println(lst);
            
        }
        catch(Exception ex) {
            ex.printStackTrace();
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
