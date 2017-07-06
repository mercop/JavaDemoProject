package solution;

import org.junit.Test;

/**
 * Created by mercop on 2017/7/4.
 */
public class Combination {

    @Test
    public void test(){
        int[] nums ={1,2};
        System.out.println("getCombination: ");
        getCombination(nums,0,"");

        System.out.println("getPermutation: ");
        getPermutation(nums,0);
    }

    public void getCombination(int[] nums,int start,String str){
        if(start == nums.length)
            System.out.println(str);
        else{
            getCombination(nums,start + 1,str + nums[start]);
            getCombination(nums,start + 1,str);
        }
    }

    public static void getPermutation(int[] nums,int index){
        if(index == nums.length){
            for(int num:nums)  {
                System.out.print(num +" ");
            }
            System.out.println();
        }

        for(int i = index;i<nums.length;i++){
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            getPermutation(nums,index+1);

            temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }
}
