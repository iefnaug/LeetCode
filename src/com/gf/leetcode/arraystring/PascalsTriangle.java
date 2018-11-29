package com.gf.leetcode.arraystring;

/*
 * Author guanfei
 * Date 2018/11/29
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle
 *   Go to Discuss
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> triangleList = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<i; j++){
                if(j == 0 || j == i-1){
                    list.add(1);
                }else{
                    list.add(triangleList.get(triangleList.size()-1).get(j) + triangleList.get(triangleList.size()-1).get(j-1));
                }
            }
            triangleList.add(list);
        }
        return triangleList;
    }

    public static void main(String[] args) {
        PascalsTriangle triangle = new PascalsTriangle();
        List<List<Integer>> triangleList = triangle.generate(5);
        for(int i=0; i<triangleList.size(); i++){
            List<Integer> list = triangleList.get(i);
            for (int j=0; j<list.size(); j++){
                System.out.print(list.get(j) + ",");
            }
            System.out.println();
        }
    }
}
