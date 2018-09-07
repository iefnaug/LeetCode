package com.gf.primary.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Author guanfei
 * Date 2018/9/7
 * Coding Forever
 *
 * 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        int x_min = 0, x_max = matrix.length - 1;
        int y_min = 0, y_max = matrix[0].length - 1;
        int direction = 1; //1:右 2:下 3:左 4:上
        int index = 0;
        int x = 0, y = 0;
        int size = matrix.length * matrix[0].length;
        Integer num[] = new Integer[size];
        while(index < size){
            num[index++] = matrix[x][y];
            if(index == size) break;
            if(direction == 1){
                y = y + 1;
                if(y > y_max){
                    x = x + 1;
                    y = y - 1;
                    x_min = x_min + 1;
                    direction = 2;
                    continue;
                }
            }else if(direction == 2){
                x = x + 1;
                if(x > x_max){
                    x = x - 1;
                    y = y - 1;
                    y_max = y_max - 1;
                    direction = 3;
                    continue;
                }

            }else if(direction == 3){
                y = y - 1;
                if(y < y_min){
                    x = x - 1;
                    y = y + 1;
                    x_max = x_max - 1;
                    direction = 4;
                    continue;
                }
            }else if(direction == 4){
                x = x - 1;
                if(x < x_min){
                    x = x + 1;
                    y = y + 1;
                    y_min = y_min + 1;
                    direction = 1;
                    continue;
                }
            }
        }
        return Arrays.asList(num);
    }

    public static void main(String[] args) {
        int martix[][] = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        List<Integer> list = spiralOrder(martix);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append(",");
        }
        System.out.println(sb.toString());
    }
}
