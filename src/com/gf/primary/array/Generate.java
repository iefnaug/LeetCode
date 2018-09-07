package com.gf.primary.array;

import java.util.ArrayList;
import java.util.List;

/*
 * Author guanfei
 * Date 2018/9/7
 * Coding Forever
 *
 * 杨辉三角
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class Generate {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows <= 0) return triangle;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        if(numRows == 1) return triangle;

        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(1);
        triangle.add(secondRow);
        if(numRows == 2) return triangle;

        for(int i=2; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1; j<i; j++){
                row.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
