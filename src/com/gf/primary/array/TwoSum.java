package com.gf.primary.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Author gf
 * Date 2018/7/24.
 * Coding Forever
 *
 *
 *   两数之和
     给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

     你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
 */
public class TwoSum {

    public static int [] twoSum(int []nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int []result = new int[2];
        for(int i=0; i<nums.length; i++){
            int search = target - nums[i];
            if(map.containsKey(search)){
                result[0] = map.get(search);
                result[1] = i;
                return result;
            }else{
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int []nums = {
//                2, 7, 11, 15, 16, 11
//        };
//        int nums[] = {3,2,4};
        int nums[] = {-1, -2, -3, -4, -5};
        int []result = twoSum(nums, -8);
        for(Integer item : result){
            System.out.print(item + ",");
        }
    }
}
