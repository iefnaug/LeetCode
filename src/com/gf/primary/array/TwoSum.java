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
        boolean flag = false;
        if(target % 2 == 0){
            flag = true;
        }
        int []result = new int[2];
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if(flag && nums[i] == target/2){
                    result[0] = map.get(nums[i]);
                    result[1] = i;
                    return result;
                }
            }else{
                map.put(nums[i], i);
            }
        }
        for(int i=0; i<nums.length; i++){
            Integer search = target - nums[i];
            if(map.containsKey(search)){
                if(flag && search == target/2)
                    continue;
                result[0] = i;
                result[1] = map.get(search);
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int []nums = {
//                2, 7, 11, 15, 16, 11
//        };
        int nums[] = {3,2,4};
        int []result = twoSum(nums, 6);
        for(Integer item : result){
            System.out.print(item + ",");
        }
    }
}
