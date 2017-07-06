package base;

import org.junit.Test;

/**
 * Created by mercop on 2017/7/4.
 * 所有继承Throwable接口的异常/错误都可以被捕获，
 * 受检异常必须捕获，runtimeException可以不捕获
 *
 */
public class ExceptionDemo {


    @Test
    public void testUserDefineException(){
        try{
            throw  new MyException();
        } catch (MyException e){
            e.printStackTrace();
            System.out.println("MyException catch!");
        }
    }

    @Test
    public void testUserDefineError(){
        try {
            throw new MyError();
        } catch (Exception e){
            System.out.println("MyError catch");
        }
    }

    @Test
    public void testException(){
        int i = 0;
        try{
            throwRunTimeException();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println(i);
        }
    }

    @Test
    public void testRuntimeException(){
        int i = 100 / 0;
        System.out.println(i);
    }

    @Test
    public void TestFinally(){
        System.out.println(finallyTest());
    }

    /*

     */

    /**
     * finally 的几种情况：
     * 1.finally 内都会执行
     * 2.try catch 中有return finally也会执行，finally中尝试修改return的返回值，
     * 此时并没有返回运算后的值，而是先把要返回的值保存起来，管finally中的代码怎么样，
     * 返回的值都不会改变，任然是之前保存的值。
     * 3.finally 中有return，则再次退出
     * @return
     */
    public int finallyTest(){
        int i = 0;
        try{
            throwRunTimeException();
        } catch (Exception e){
            return i;

        } finally {
            System.out.println("finally before changed: " + i);
            i = 10;
            System.out.println("finally after changed: " + i);
            //return i;
        }
        return -1;
    }

    public void throwRunTimeException() throws Exception{
        throw new RuntimeException("Runtime exception");
    }

    class MyException extends RuntimeException{

    }

    class MyError extends Error{

    }
}
