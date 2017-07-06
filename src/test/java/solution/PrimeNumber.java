package solution;

import java.util.ArrayList;

/**
 * Created by mercop on 2017/7/4.
 * 获取所有素数，通过前面的素数，去标记后面为该素数倍数的数为非素数
 */
public class PrimeNumber {
    public static void main(String[] args){
        int n = 101;
        int[] a = new int[n];
        a[1] = 1;
        a[2] = 0;
        for(int i = 2; i < n;i++){
            if(a[i] == 0)
                for(int j = i + i; j < n;){
                    a[j] = 1;
                    j += i;
                }
        }
        //0 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
        //0 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

        for(int i = 2; i < n; i++)
            if(a[i] == 0)
                System.out.print(i + " ");

    }
}
