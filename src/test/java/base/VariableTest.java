package base;

import org.junit.Test;

/**
 * Created by mercop on 2017/7/4.
 */
public class VariableTest {

    @Test
    public void test1(){
        //错误方式
/*        for(int i = 0; i < 10; i++)
            Integer k = new Integer(i);*/
        //需要加括号
        for(int i = 0; i < 10; i++){
            Integer k = new Integer(i);
        }
        System.out.println("Hello World");
    }

    @Test
    public void test2(){
        System.out.println("is "+ 100 + 5);
        System.out.println(100 + 5 +" is");
        System.out.println("is "+ (100 + 5));
    }
}
