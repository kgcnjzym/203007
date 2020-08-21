package test;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 异常示例：通过异常处理
 * 
 * @author 杨卫兵
 * @version [V1.00, 2020年8月20日]
 * @since V1.00
 */
public class Test2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("pls input:");        
            int a = scanner.nextInt();
            System.out.println("pls input:");        
            int b = scanner.nextInt();        
            int c = a / b;
            System.out.printf("%d/%d=%d\n", a, b, c);
        }
        catch(ArithmeticException ex) {
            System.out.println("出错了："+ex);
        }
        catch(InputMismatchException ex) {
            System.out.println("出错了："+ex);
        }
        catch(RuntimeException e) {}        
        finally {
            System.out.println("finally");
        }
        System.out.println("end of main");
        
        scanner.close();
        
    }
    
}















