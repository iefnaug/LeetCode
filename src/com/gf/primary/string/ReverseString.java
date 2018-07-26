package com.gf.primary.string;/*
 * Author guanfei
 * Date 2018/7/26
 * Coding Forever
 */

public class ReverseString {

    static String reverseString(String s){
        if(s == null) return s;

        char []charArray = s.toCharArray();
        int start = 0;
        int end = s.length()-1;

        while(start < end){
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        String str = "edoc eht em wohs ,paehc si klat";
        System.out.println(reverseString(str));
    }
}
