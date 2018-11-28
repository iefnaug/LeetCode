package com.gf.leetcode.arraystring;

/*
 * Author guanfei
 * Date 2018/11/28
 */

/**
 * Diagonal Traverse
 *   Go to Discuss
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 *
 *
 *
 * Example:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * Output:  [1,2,4,7,5,3,6,8,9]
 *
 * Explanation:
 *
 *
 *
 * Note:
 *
 * The total number of elements of the given matrix will not exceed 10,000.
 */
public class DiagonalTraverse {

    /**
     * 遍历有两个方向，右上和左下
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[0];
        }
        int totalSize = matrix.length * matrix[0].length;
        int[] result = new int[totalSize];
        int visited = 0;
        int x=1, y=-1;
        boolean up = true;
        while(visited < totalSize){
            if(up){
                if(y == matrix[0].length - 1){
                    result[visited++] = matrix[(x+=1)][y];
                    up = false;
                }else if(x == 0){
                    result[visited++] = matrix[x][(y+=1)];
                    up = false;
                }else{
                    result[visited++] = matrix[(x-=1)][(y+=1)];
                }
            }else{
                if(x == matrix.length - 1){
                    result[visited++] = matrix[x][(y+=1)];
                    up = true;
                }else if(y == 0){
                    result[visited++] = matrix[(x+=1)][y];
                    up = true;
                }else{
                    result[visited++] = matrix[(x+=1)][(y-=1)];
                }

            }
        }
        return result;
    }


    public static void main(String[] args) {
        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        int[] result = diagonalTraverse.findDiagonalOrder(matrix);
        for(int each : result){
            System.out.print(each + ",");
        }

    }
}
