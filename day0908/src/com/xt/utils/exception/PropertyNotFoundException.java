package com.xt.utils.exception;
/**
 * 自定义异常：属性找不到
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月9日]
 * @since V1.00
 */
public class PropertyNotFoundException extends Exception
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public PropertyNotFoundException(String propertyName)
    {
        super("属性【"+propertyName+"】找不到！");
    }
    
    
    
}
