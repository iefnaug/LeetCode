package com.gf.leetcode.arraystring;

/**
 * Author guanfei
 * Date 2018/11/28.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new ArrayList<>();
        }
        int totalSize = matrix.length * matrix[0].length;
        List<Integer> resultList = new ArrayList<>();
        int x=0, y=-1;
        int x_min = 0, x_max = matrix.length-1;
        int y_min = 0, y_max = matrix[0].length-1;
        int direction = 1; //1: right; 2: down; 3: left; 4: up
        while(resultList.size() < totalSize){
            if(direction == 1){
                if(y == y_max){
                    resultList.add(matrix[x+=1][y]);
                    direction = 2;
                    x_min += 1;
                }else{
                    resultList.add(matrix[x][y+=1]);
                }
            }else if(direction == 2){
                if(x == x_max){
                    resultList.add(matrix[x][y-=1]);
                    direction = 3;
                    y_max -= 1;
                }else{
                    resultList.add(matrix[x+=1][y]);
                }
            }else if(direction == 3){
                if(y == y_min){
                    resultList.add(matrix[x-=1][y]);
                    direction = 4;
                    x_max -= 1;
                }else{
                    resultList.add(matrix[x][y-=1]);
                }
            }else if(direction == 4){
                if(x == x_min){
                    resultList.add(matrix[x][y+=1]);
                    direction = 1;
                    y_min += 1;
                }else{
                    resultList.add(matrix[x-=1][y]);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        List<Integer> resultList = spiralMatrix.spiralOrder(matrix);
        for(int each : resultList){
            System.out.print(each + ",");
        }
    }
}
