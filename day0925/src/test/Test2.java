package test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.xt.entity.Scene;
import com.xt.utils.XMLUtil;

public class Test2
{
    static List<Scene> lst=new ArrayList<>();
    static {

        InputStream is=null;
        SAXBuilder builder=null;
        try {
            is=Test.class.getClassLoader().getResourceAsStream("Scene.xml");
            builder=new SAXBuilder();
            Document doc=builder.build(is);
            Element root=doc.getRootElement();
            
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
    
    public static void main(String[] args)
    {
        Scene s1=getScene(0);
        Scene s2=getScene(0);
        s1.setNumber(100);
        s2.setNumber(10);
        System.out.println(s1.getNumber());
        System.out.println(s2.getNumber());
    }

    private static Scene getScene(int i)
    {
//        return lst.get(i);
        try
        {
            return (Scene)(lst.get(i).clone());
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }
    
    
    
}
