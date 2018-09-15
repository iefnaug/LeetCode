package com.gf.primary.array;

/*
 * Author guanfei
 * Date 2018/9/14
 * Coding Forever
 *
 *
 *
 * 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 */

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0 || strs[0] == null) return "";
        if(strs.length == 1) return strs[0] == null ? "" : strs[0];
        int shortestStr = strs[0].length();
        for(String str : strs){
            shortestStr = str == null ? 0 : str.length() > shortestStr ? shortestStr : str.length();
        }
        String prefix = "";
        boolean exit = false;
        for(int i=0; i<shortestStr; i++){
            if(exit) break;
            char first = strs[0].charAt(i);
            int equalTimes = 0;
            for(int j=1; j< strs.length; j++) {
                if (strs[j].charAt(i) == first)
                    equalTimes++;
                else{
                    exit = true;
                    break;
                }

            }
            if(equalTimes == strs.length - 1)
                prefix += first;
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0 || strs[0] == null) return "";
        if(strs.length == 1) return strs[0] == null ? "" : strs[0];
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++){
            String anotherStr = strs[i];
            int len = prefix.length() > anotherStr.length() ? anotherStr.length() : prefix.length();
            String temp = "";
            for(int j=0; j<len; j++){
                if(prefix.charAt(j) == anotherStr.charAt(j)){
                    temp += prefix.charAt(j);
                }else{
                    break;
                }
            }
            if(temp.length() == 0) return "";
            prefix = temp;
        }
        return prefix;
    }

    public static void main(String[] args) {
        String strs[] = new String[]{
                "aca", "cba"
        };

        System.out.println(longestCommonPrefix(strs));
    }
}
