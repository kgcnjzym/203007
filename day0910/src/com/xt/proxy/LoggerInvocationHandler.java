package com.xt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * 自定义方法反射处理器的实现类
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月10日]
 * @since V1.00
 */
public class LoggerInvocationHandler implements InvocationHandler
{
    private Object target;
    public LoggerInvocationHandler(Object target) {
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable
    {
        if(args!=null && args.length>0) {
            LoggerRecord.log(method.getName()+"执行前，参数是："+Arrays.toString(args));
        }
        else {
            LoggerRecord.log(method.getName()+"执行前，无参数。");
        }
        Object ret=method.invoke(target, args);
        LoggerRecord.log(method.getName()+"执行后，返回值是："+ret);
        return ret;
    }
    
}
