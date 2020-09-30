package com.xt.dao.impl;

import com.xt.dao.InterA;
import com.xt.dao.InterB;
/**
 * 如果多个父接口中有相同签名的默认方法时，
 * 子类必须重写默认方法
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月30日]
 * @since V1.00
 */
public class SubClass implements InterA, InterB
{
    /**
     * 在重写方法体中指定调用哪个父接口的默认方法，
     * 或者自行给出新的方法实现
     * @return
     */
    @Override
    public int test()
    {
        return InterB.super.test();
    }
}
