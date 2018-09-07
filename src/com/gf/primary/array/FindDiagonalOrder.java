package com.gf.primary.array;

/*
 * Author guanfei
 * Date 2018/9/6
 * Coding Forever
 *
 * 对角线遍历(正方形对角线)
给定一个含有 M x N 个元素的矩阵（M行，N列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

示例:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出:  [1,2,4,7,5,3,6,8,9]
解释:

说明:

给定矩阵中的元素总数不会超过 100000 。
 */
public class FindDiagonalOrder {

    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[]{};
        int m = matrix.length;
        int n = matrix[0].length;
        int []num = new int[m * n]; //转换成一维数组后的长度
        boolean isRightTop = true;

        //下是x轴正方向，右是y轴正方向
        int i = 0; //横坐标
        int j = 0; //纵坐标
        int position = 0;
        while(position < num.length){
            num[position] = matrix[i][j];
            if(++position == num.length) break;
            if(isRightTop){ //(-1, 1)横-1,纵+1
                i = i - 1;
                j = j + 1;
                if(j >= n){
                    i = i + 2;
                    j = j - 1;
                    isRightTop = false;
                }else if(i < 0){
                    i = i + 1;
                    isRightTop = false;
                }
            }else{ //(1, -1) 横+1,纵-1
                i = i + 1;
                j = j - 1;
                if(i >= m){
                    i = i - 1;
                    j = j + 2;
                    isRightTop = true;
                }else if(j < 0){
                    j = j + 1;
                    isRightTop = true;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int martix[][] = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        int num[] = findDiagonalOrder(martix);
        StringBuilder sb = new StringBuilder();
        for(int each : num){
            sb.append(each).append(",");
        }
        System.out.println(sb.toString());
    }
}
