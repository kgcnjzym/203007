package com.xt.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 控制台输入工具类
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年8月20日]
 * @since V1.00
 */
public class InputUtil
{
    public static Scanner scanner;
    
    /**
     * 接受输入的一个整数
     * 
     * @return
     */
    public static int acceptInt()
    {
        int n = 0;
        do
        {
            try
            {
                n = scanner.nextInt();
                break;
            }
            catch (InputMismatchException ex)
            {
                scanner.next();
                System.out.println("输入的不是整数，请重新输入！");
            }
        } while (true);
        return n;
    }
    
    /**
     * 
     * 接受输入的一个整数,必须在min-max之间
     * 
     * @param min 最小数
     * @param max 最大数
     * @return
     */
    public static int acceptInt(int min, int max)
    {
        int n;
        do
        {
            n = acceptInt();
            if (n < min || n > max)
            {
                System.out.printf("请输入%d-%d之间的整数。\n",min,max);
                continue;
            }
            break;
        } while (true);
        return n;
    }
}
