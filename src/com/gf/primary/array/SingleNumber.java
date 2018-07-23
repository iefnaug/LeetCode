package com.gf.primary.array;
/*
 * Author guanfei
 * Date 2018/7/23
 * Coding Forever
 *
 * 只出现一次的数字
    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

    说明：

    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

    示例 1:

    输入: [2,2,1]
    输出: 1
    示例 2:

    输入: [4,1,2,1,2]
    输出: 4
 */

public class SingleNumber {

    /**
     * 任何数与0做异或运算，都等于其本身
     * A ^ B ^ B = A
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length; i++){

            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int []nums = new int[]{
                4,1,2,1,2
        };

    }

}
