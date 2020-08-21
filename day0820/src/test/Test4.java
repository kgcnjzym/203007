package test;

import java.util.Scanner;

import com.xt.utils.InputUtil;

/**
 * InputUtil的使用示例
 * @author  杨卫兵
 * @version  [V1.00, 2020年8月20日]
 * @since V1.00
 */
public class Test4
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        InputUtil.scanner=scanner;
        
//        test1();
        
        test2();
        
        scanner.close();
        
    }

    private static void test2()
    {
        System.out.println("请输入年龄（0-120）：");
        int a=InputUtil.acceptInt(0,120);
        System.out.println("a="+a);
        
    }

    private static void test1()
    {
        System.out.println("请输入整数：");
        int a=InputUtil.acceptInt();
        System.out.println("a="+a);
        
    }
    
}
