package com.gf.primary.string;/*
 * Author guanfei
 * Date 2018/7/31
 * Coding Forever
 *
 *
 *
 * 实现strStr()
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */

public class Strstr {

    static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
            return -1;
        if("".equals(needle))
            return 0;

        int haystack_len = haystack.length();
        int needle_len = needle.length();
        if(haystack_len < needle_len)
            return -1;

        int stop = haystack_len - needle_len;
        int haystack_index = 0;
        int needle_index = 0;
        while(haystack_index <= stop){
            for(int i=0; i<needle_len; i++){
                if(haystack.charAt(haystack_index + i) == needle.charAt(i)){
                    needle_index++;
                }else{
                    needle_index = 0;
                    break;
                }
            }
            if(needle_index == needle.length()){
                return haystack_index;
            }
            haystack_index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "guanfei";
        String str2 = "fe";
        System.out.println(strStr(str1, str2));
    }
}
