package com.gf.primary.array;

/*
 * Author guanfei
 * Date 2018/7/22
 * Coding Forever
 *
 *  旋转数组
    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

    示例 1:

    输入: [1,2,3,4,5,6,7] 和 k = 3
    输出: [5,6,7,1,2,3,4]
    解释:
    向右旋转 1 步: [7,1,2,3,4,5,6]
    向右旋转 2 步: [6,7,1,2,3,4,5]
    向右旋转 3 步: [5,6,7,1,2,3,4]
    示例 2:

    输入: [-1,-100,3,99] 和 k = 2
    输出: [3,99,-1,-100]
    解释:
    向右旋转 1 步: [99,-1,-100,3]
    向右旋转 2 步: [3,99,-1,-100]
    说明:

    尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
    要求使用空间复杂度为 O(1) 的原地算法。
 */

public class RotateArray {

    /**
     * Solution1: 一个一个地向左移动，移动k次
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        if(k <= nums.length/2){
            for(int times=0; times<k; times++){
                int moveToLeft = nums[nums.length - 1];
                for(int i = nums.length-1; i > 0; i--){
                    nums[i] = nums[i-1];
                }
                nums[0] = moveToLeft;
            }
        }else{
            k = nums.length - k;
            for(int times=0; times<k; times++){
                int moveToRight = nums[0];
                for(int i=0; i<nums.length-1; i++){
                    nums[i] = nums[i+1];
                }
                nums[nums.length - 1] = moveToRight;
            }
        }


    }

    public static void rotate2(int []nums, int k){

        if(nums.length <= 1){
            return;
        }
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public static void reverse(int nums[], int start, int end){
//        int se = start + end;
//        int mid = se/2;
//        for(int i=start; i<=mid; i++){
//            int temp = nums[i];
//            nums[i] = nums[se - i];
//            nums[se - i] = temp;
//        }

        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int []nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
//        int []nums = new int[]{1};
        rotate2(nums, 6);
        for(int each : nums){
            System.out.print(each + ",");
        }
    }
}
