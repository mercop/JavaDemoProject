package base;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by mercop on 2017/7/4.
 */
public class Reflection {

    @Test
    public void test1() {
        printClassMethodMessage(int.class);
        System.out.println();
        printConMessage(int.class);
    }

    public static void printClassMethodMessage(Object obj) {
        Class c = obj.getClass();
        System.out.println("类的名称是:" + c.getName());
        Method[] ms = c.getMethods();//c.getDeclaredMethods()
        for (int i = 0; i < ms.length; i++) {
            //然后可以得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            //得到方法的返回值类型的名字
            System.out.print(returnType.getName() + " ");
            //得到方法的名称
            System.out.print(ms[i].getName() + "(");
            //获取参数类型--->得到的是参数列表的类型的类类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }

    public static void printConMessage(Object obj) {
        Class c = obj.getClass();
        Constructor[] cs = c.getDeclaredConstructors();
        for (Constructor constructor : cs) {
            System.out.print(constructor.getName() + "(");
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }

}
