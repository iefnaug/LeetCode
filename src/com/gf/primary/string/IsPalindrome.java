package com.gf.primary.string;

/*
 * Author guanfei
 * Date 2018/9/20
 * Coding Forever
 *
 * 验证回文字符串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。
示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
 */
public class IsPalindrome {

    public static boolean isPalindrome(String s) {

        if(s == null) return false;
        if(s.length() == 0) return true;

        s = s.toUpperCase();
        int len = s.length();
        char c[] = new char[len];
        int index = 0;
        for(int i=0; i<len; i++){
            char each = s.charAt(i);
            if( (each >= '0' && each <= '9') || (each >= 'A' && each <= 'Z') ){
                c[index++] = s.charAt(i);
            }
        }

        for(int i=0; i<index/2; i++){
            if(c[i] != c[index - i -1]){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String str = " ";
        System.out.println(isPalindrome(str));
    }
}
