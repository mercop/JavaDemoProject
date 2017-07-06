package solution;
import org.junit.Test;

import java.util.ArrayList;
/**
 * Created by mercop on 2017/7/5.
 * 顺时针打印矩阵
 */
public class PrintMatrix {

    @Test
    public void test(){
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8},{9, 10, 11, 12}, {13, 14, 15, 16}};
        //int[][] nums = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12,13, 14, 15}};
        //int[][] nums = {{1,2},{3,4},{5,6},{7,8}};
        //int[][] nums = {{1,2},{3,4}};
        for(Integer i : printMatrix(nums))
            System.out.print(i + " ");
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if(matrix == null)
            return null;
        int row = matrix.length;
        int col = matrix[0].length;

        int startx = 0,starty = 0;
        if(row == 1){
            for(int i= 0; i < col;i++)
                resultList.add(matrix[0][i]);
            return resultList;
        }

        if(col == 1){
            for(int i= 0; i < row;i++)
                resultList.add(matrix[i][0]);
            return resultList;
        }


        while(row > startx * 2 && col > starty * 2){
            for(int i = starty; i <= col - starty - 1; i++){
                resultList.add(matrix[startx][i]);
            }
            if(startx < row - startx - 1)
                for(int j = startx + 1; j <= row - startx - 1; j ++){
                    resultList.add(matrix[j][col - starty - 1]);
                }
            if(col - starty - 1 > starty && startx < row - startx - 1)
                for(int i = col - starty - 2; i >= starty; i --){
                    resultList.add(matrix[row - startx - 1][i]);
                }
            if(col - starty - 1 > starty && startx < row - startx - 1)
                for(int j = row - startx - 2; j > startx; j --){
                    resultList.add(matrix[j][starty]);
                }
            startx ++;
            starty ++;
        }

        return resultList;
    }
}
