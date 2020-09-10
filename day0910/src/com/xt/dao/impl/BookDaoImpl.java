package com.xt.dao.impl;

import com.xt.dao.BookDao;

public class BookDaoImpl implements BookDao
{
    
    @Override
    public int add(String isbn, String title, float price)
    {
        if(isbn!=null && ! isbn.trim().equals("")) {
            return 1;
        }
        return 0;
    }
    
    @Override
    public int delete(String isbn)
    {
        if(isbn!=null && ! isbn.trim().equals("")) {
            return 1;
        }
        return 0;
    }
    
}
