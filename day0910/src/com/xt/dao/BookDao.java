package com.xt.dao;
/**
 * 图书的数据访问接口
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月10日]
 * @since V1.00
 */
public interface BookDao
{
    int add(String isbn,String title,float price);
    
    int delete(String isbn);
}
