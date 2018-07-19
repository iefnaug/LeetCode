package com.gf.primary.array;
/**
 * Author gf
 * Date 2018/7/17.
 * Coding Forever
 */

/**
 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 示例 1:

 给定数组 nums = [1,1,2],

 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

 你不需要考虑数组中超出新长度后面的元素。
 示例 2:

 给定 nums = [0,0,1,1,1,2,2,3,3,4],

 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

 你不需要考虑数组中超出新长度后面的元素。
 */

public class RemoveDuplicates {
    /**
     * Solution1: 发现重复，把重复值之后的元素往前移动一位，然后把重复的值移动到数组的最后
     * @param nums
     * @return
     */
    int removeDuplicates(int []nums){

        if(nums.length <= 1){
            return nums.length;
        }
        int flag = 0; //重复元素的个数
        int prev = nums[0];
        int i;
        for(i=1; i<nums.length; i++){
            while(prev == nums[i]){
                if(flag + i + 1 == nums.length){
                    return i;
                }
                move(nums, i);
                flag++;
            }
            if(flag + i + 1 == nums.length){
                return i+1;
            }
            prev = nums[i];
        }
        return i;
    }

    /**
     * @param nums
     * @param position
     * @return
     */
    void move(int []nums, int position){
        for(int i=position; i<nums.length - 1; i++){
            nums[i] = nums[i+1];
        }
    }

    public static void main(String[] args) {
        int []nums = {1,1,2,3,3,4,4,4,5,6,6,6,6,7,8,8,8,8,9,9,9};
//        int []nums = {1,1};
//        int []nums = {1,2,3,4,5,6};
        int length = new RemoveDuplicates().removeDuplicates(nums);
        for(int i=0; i<length; i++){
            System.out.print(nums[i] + ",");
        }
    }
}
