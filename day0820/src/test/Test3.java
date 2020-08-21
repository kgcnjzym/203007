package test;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 异常示例：finally
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年8月20日]
 * @since V1.00
 */
public class Test3
{
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        int ret = test1();
        System.out.println("ret=" + ret);
        scanner.close();
        
        System.out.println("========");
        int a;
        try
        {
            a = 10;
        }
//        catch(Exception ex){}
        finally {}
        System.out.println("a=" + a);
    }
    
    private static int test1()
    {
        try
        {
            System.out.println("pls input:");
            int a = scanner.nextInt();
            System.out.println("pls input:");
            int b = scanner.nextInt();
            return a / b;
        }
        catch (Exception ex)
        {
            System.out.println("出错了：" + ex);
            System.exit(0);
            return 0;
        }
        finally
        {
            System.out.println("finally");
            // return 100;
        }
        // System.out.println("end of test1");
        
    }
    
}
