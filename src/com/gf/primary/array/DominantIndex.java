package com.gf.primary.array;

/*
 * Author guanfei
 * Date 2018/8/12
 * Coding Forever
 *
 *
 * 在一个给定的数组nums中，总是存在一个最大元素 。

查找数组中的最大元素是否至少是数组中每个其他数字的两倍。

如果是，则返回最大元素的索引，否则返回-1。

示例 1:

输入: nums = [3, 6, 1, 0]
输出: 1
解释: 6是最大的整数, 对于数组中的其他整数,
6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.


示例 2:

输入: nums = [1, 2, 3, 4]
输出: -1
解释: 4没有超过3的两倍大, 所以我们返回 -1.


提示:

nums 的长度范围在[1, 50].
每个 nums[i] 的整数范围在 [0, 99].
 */
public class DominantIndex {

    public static int dominantIndex(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        if(nums.length == 1)
            return 0;
        int index;
        int prev;
        int current;
        if(nums[0] < nums[1]){
            prev = nums[0];
            current = nums[1];
            index = 1;
        }else{
            prev = nums[1];
            current = nums[0];
            index = 0;
        }

        for(int i=2; i<nums.length; i++){
            if(nums[i] >= current) {
                prev = current;
                current = nums[i];
                index = i;
            }

            if(nums[i] > prev && nums[i] < current){
                prev = nums[i];
            }
        }

        return current >= prev * 2 ? index : -1;
    }

    public static void main(String[] args) {
        int []nums = {
                1,2,3,4,20
        };

        System.out.println(dominantIndex(nums));
    }

}
