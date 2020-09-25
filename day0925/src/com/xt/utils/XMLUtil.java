package com.xt.utils;

import java.lang.reflect.Method;
import java.util.List;

import org.jdom.Element;

/**
 * XML工具类
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月25日]
 * @since V1.00
 */
public class XMLUtil
{
    /**
     * 通过XML解析得到一个指定类型的对象
     * @param <T>       指定类型
     * @param element   XML元素
     * @param clz       指定类型的Class对象
     * @return          指定类型的对象
     */
    @SuppressWarnings("rawtypes")
    public static <T> T getObjectFromElement(Element element,Class<T> clz) {
        T obj=null;
        try {
            obj=clz.newInstance();
            List subs=element.getChildren();
            for(Object sub:subs) {
                Element elm=(Element)sub;
                Method mth=ObjectUtil.getSetterByPropertyName(
                    clz, elm.getName());
                if(mth!=null) {
                    Class<?> type=mth.getParameterTypes()[0];
                    Object value=ObjectUtil.convertToObject(elm.getText(),type);
                    mth.invoke(obj, value);
                }                
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return obj;
    }
}
