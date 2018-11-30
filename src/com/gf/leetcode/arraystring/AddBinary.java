package com.gf.leetcode.arraystring;

/*
 * Author guanfei
 * Date 2018/11/30
 */

/**
 * Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {

    public String addBinary(String a, String b) {

       return  a.length() >= b.length() ? handle(a, b) : handle(b, a);

    }

    private String handle(String longer, String shorter){
        int longer_len = longer.length()-1;
        int shorter_len = shorter.length()-1;
        int plus_one = 0;
        StringBuilder resultStr = new StringBuilder();
        while(longer_len >= 0){
            int sum = shorter_len >= 0
                    ? longer.charAt(longer_len) + shorter.charAt(shorter_len) - 96 + plus_one
                    : longer.charAt(longer_len) - 48 + plus_one;
            if(sum >= 2){
                resultStr.append(sum-2);
                plus_one = 1;
            }else{
                resultStr.append(sum);
                plus_one = 0;
            }
            longer_len--;
            shorter_len--;
        }

        if(plus_one == 1){
            resultStr.append(1);
        }

        return resultStr.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String a = "11";
        String b = "1";
        System.out.println(addBinary.addBinary(a, b));
    }
}
