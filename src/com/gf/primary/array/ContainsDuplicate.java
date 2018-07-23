package com.gf.primary.array;
/*
 * Author guanfei
 * Date 2018/7/23
 * Coding Forever
    存在重复
    给定一个整数数组，判断是否存在重复元素。

    如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

    示例 1:

    输入: [1,2,3,1]
    输出: true
    示例 2:

    输入: [1,2,3,4]
    输出: false
    示例 3:

    输入: [1,1,1,3,3,4,3,2,4,2]
    输出: true
 */

import java.util.Arrays;

public class ContainsDuplicate {

    /**
     * Solution1 : 暴力破解，穷举, 时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        if(nums.length < 2)
            return false;
        Arrays.sort(nums);
        int j=0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int nums[] = new int[100000];
        for(int i=0; i<nums.length - 1; i++){
            nums[i] = i;
        }
        nums[99999] = 99998;

        long start = System.currentTimeMillis();
        System.out.println(containsDuplicate2(nums));
        long end = System.currentTimeMillis();
        System.out.println(end - start); //1151
    }
}
