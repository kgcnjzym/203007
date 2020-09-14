package com.xt.th;

/**
 * 0911课后练习线程类
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年9月14日]
 * @since V1.00
 */
public class MyRunner implements Runnable
{
    private Integer type;
    
    public MyRunner(Integer type)
    {
        this.type = type;
    }
    
    @Override
    public void run()
    {
        for (int i = 0; i < 26; i++)
        {
            String s="";
            if (type == 1)
            {
                s=""+(char)('A'+i);
            }
            else if (type == 2)
            {
                s=""+(char)('a'+i);
            }
            else
            {
                s=""+(i+1);
            }
            System.out.println(s);
        }
        
    }
    
}
