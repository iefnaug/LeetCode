package com.gf.leetcode.arraystring;

/*
 * Author guanfei
 * Date 2018/11/25
 */

/**
 * Find Pivot Index
 *   Go to Discuss
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 *
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 *
 * Example 1:
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * Example 2:
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Note:
 *
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class FindPivotIndex {

    /**
     * 暴力破解，对于每个索引，计算其左右的和
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int sumOfLeft = 0;
            int sumOfRight = 0;
            for(int j=0; j<=i; j++){
                sumOfLeft += nums[j];
            }
            for(int k=i; k<nums.length; k++){
                sumOfRight += nums[k];
            }
            if(sumOfLeft == sumOfRight){
                return i;
            }
        }
        return -1;
    }


    /**
     * DP
     * @param nums
     * @return
     */
    public int pivotIndex2(int[] nums) {
        int leftSum = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        for(int j=0; j<nums.length; j++){
            if(leftSum * 2 == sum - nums[j]){
                return j;
            }
            leftSum += nums[j];
        }
        return -1;
    }


    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int nums[] = {
                1,2,3,4,5,4,3,2,1,9
        };
        int index = findPivotIndex.pivotIndex2(nums);
        System.out.println(index);
    }
}
