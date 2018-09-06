package com.gf.primary.array;

/*
 * Author guanfei
 * Date 2018/9/6
 * Coding Forever
 *
 *
 *
 * 加一
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    /**
     * 只有所有的数字都是9，数组才需要扩容
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        for(int i=digits.length-1; i>=0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        if(digits[digits.length - 1] != 0){
            return digits;
        }

        int []newArr = new int[digits.length + 1];
        newArr[0] = 1;
        return newArr;
    }


    public static void main(String[] args) {
        int []arr = new int[]{
                9,9,9,9,9
        };

        int []newArr = plusOne(arr);
        System.out.println();
    }

}
