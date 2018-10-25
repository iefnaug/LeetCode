package com.gf.leetcode.queue;

/*
 * Author guanfei
 * Date 2018/10/24
 */

/**
 * Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int island = 0;
        int x = grid.length;
        int y = grid[0].length;
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(grid[i][j] == '1'){
                    findNeighbors(i, j, grid);
                    island++;
                }
            }
        }
        return  island;
    }

    public void findNeighbors (int x, int y, char[][] grid){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length){
            return;
        }
        if(grid[x][y] == '1'){
            grid[x][y] = '0';
            findNeighbors(x-1, y, grid);
            findNeighbors(x, y-1, grid);
            findNeighbors(x+1, y, grid);
            findNeighbors(x, y+1, grid);
        }

    }

    public static void main(String[] args) {
        char [][]grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        NumIslands numIslands = new NumIslands();
        int size = numIslands.numIslands(grid);
        System.out.println(size);
    }
}
