package com.gf.leetcode.arraystring;

/*
 * Author guanfei
 * Date 2018/11/25
 */

/**
 * Largest Number At Least Twice of Others
 *   Go to Discuss
 * In a given integer array nums, there is always exactly one largest element.
 *
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 *
 * If it is, return the index of the largest element, otherwise return -1.
 *
 * Example 1:
 *
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 *
 *
 * Example 2:
 *
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 *
 *
 * Note:
 *
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 */
public class LargestNumberAtLeastTwiceofOthers {

    /**
     * 遍历数组找出最大的数和次大的数
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        if(nums == null){
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }
        int first, second, index=0;
        first = nums[0];
        second = first/2 -1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] >= first){
                second = first;
                first = nums[i];
                index = i;
            }else if(nums[i] > second){
                second = nums[i];
            }
        }
        return first >= 2 * second ? index : -1;
    }

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceofOthers obj = new LargestNumberAtLeastTwiceofOthers();
        int[] nums = {
                1,2,3,4,9
        };
        int result = obj.dominantIndex(nums);
        System.out.println(result);
    }
}
