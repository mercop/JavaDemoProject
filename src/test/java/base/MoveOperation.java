package base;

import org.junit.Test;

/**
 * Created by mercop on 2017/7/4.
 * java 中的移位运算
 */
public class MoveOperation {

    @Test
    public void test1(){
        int i = 10;
        int i2 = -10;
        //右移动两位 result 2 -3
        System.out.println(i >> 2);
        System.out.println(i2 >> 2);

        //result 0
        System.out.println(i >> 5);

        //无符号右移两位
        System.out.println(i >>> 2);
        System.out.println(i2 >>> 2);

        //int移动数大于32时 mod 32
        System.out.println(i >>34);

        long l1 = 10L;
        //long 移动数大于64时 mod 64
        System.out.println(l1 >> 2);
        System.out.println(l1 >> 66);

        byte b = (byte)1;
        //byte 转换为int操作
        System.out.println(b << 1);
        System.out.println(b << 10);
    }
}
