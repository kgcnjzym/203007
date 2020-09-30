package test;

import com.xt.dao.CarDao;
import com.xt.dao.InterA;
import com.xt.dao.impl.SubClass;

/**
 * 默认方法测试
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月30日]
 * @since V1.00
 */
public class Test1
{
    
    public static void main(String[] args)
    {
        InterA c=new SubClass();
        System.out.println(c.test());
        CarDao.test();
    }
    
}
