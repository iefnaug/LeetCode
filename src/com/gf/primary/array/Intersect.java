package com.gf.primary.array;

/*
 * Author guanfei
 * Date 2018/7/24
 * Coding Forever
 *
 *
 *  两个数组的交集 II
 *
    给定两个数组，写一个方法来计算它们的交集。

    例如:
    给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].

    注意：

       输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
       我们可以不考虑输出结果的顺序。
    跟进:

    如果给定的数组已经排好序呢？你将如何优化你的算法？
    如果 nums1 的大小比 nums2 小很多，哪种方法更优？
    如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 */


import java.util.HashMap;

public class Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        /**
         * 将nums1的值放入map, 默认1，如果有重复，则加1
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }else{
                map.put(nums1[i], 1);
            }
        }

        /**
         * 新数组的最大长度不超过 min(nums1.length, nums2.length)
         */
        int result[] = new int[nums1.length > nums2.length ? nums2.length : nums1.length];

        /**
         * 遍历nums2，如果nums[k] 在map中，则nums[k]是交集元素之一
         */
        int index = 0;
        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                result[index] = nums2[i];
                index++;
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        /**
         * 调整数组的大小
         */
        int []answer = new int[index];
        for(int i=0; i<answer.length; i++){
            answer[i] = result[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int nums1[] = new int []{1,3,5,7,9, 11, 11};
        int nums2[] = new int []{2,4,6,9,11,11};
//        int nums1[] = new int []{1};
//        int nums2[] = new int []{1, 1};

        int []result = intersect(nums1, nums2);
        for(int item : result){
            System.out.print(item + ",");
        }

//        int h = new Integer(222).hashCode();
//        int s = new Integer(222).hashCode();
//        System.out.println(h);
//        System.out.println(s);
    }
}
