package com.gf.leetcode.arraystring;

/*
 * Author guanfei
 * Date 2018/11/28
 */


/**
 * Plus One
 *   Go to Discuss
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {


    public int[] plusOne(int[] digits) {

        int plusOne = 1;
        for(int i=digits.length - 1; i>=0; i--){
            int sum = digits[i] + plusOne;
            if(sum > 9){
                digits[i] = 0;
            }else{
                digits[i] = sum;
                plusOne = 0;
                break;
            }
        }
        if(plusOne == 1){
            int []arr = new int[digits.length + 1];
            arr[0] = 1;
            System.arraycopy(digits, 0, arr, 1, digits.length);
            return arr;
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {
                9,9,9,9
        };
        digits = plusOne.plusOne(digits);
        for(int each : digits){
            System.out.print(each);
        }
    }
}
