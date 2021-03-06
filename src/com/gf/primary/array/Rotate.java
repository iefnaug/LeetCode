package com.gf.primary.array;

/*
 * Author guanfei
 * Date 2018/9/18
 * Coding Forever
 *
 *
 *
 * 旋转图像
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]


此题注意坐标之间的变化 (x1, y1)转动前， (x2, y2)转动后   x2=n-1-y1, y2=x1
 */
public class Rotate {

    public static void rotate(int[][] matrix) {

        if(matrix == null || matrix[0].length == 0) return;
        int n = matrix.length;

        for(int x = 0; x < n/2; x++){
            for(int y = x; y < n-1-x; y++){
                int temp = matrix[x][y];
                matrix[x][y]  = matrix[n-1-y][x];
                matrix[n-1-y][x] = matrix[n-1-x][n-1-y];
                matrix[n-1-x][n-1-y] = matrix[y][n-1-x];
                matrix[y][n-1-x] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int [][]matrix = new int[][]{
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };

        rotate(matrix);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(String.format("%3d", matrix[i][j]));
            }
            System.out.println();
        }
    }
}
