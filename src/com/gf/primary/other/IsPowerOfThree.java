package com.gf.primary.other;

/*
 * Author guanfei
 * Date 2018/8/10
 * Coding Forever
 *
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class IsPowerOfThree {

    /**
     * 时间复杂度O(log N)
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
       while (n > 0){
           if(n % 3 == 0){
               n = n / 3;
           }else{
               return false;
           }
           if(n == 1){
               return true;
           }
       }
       return false;
    }

    /**
     *1162261467 整数范围最大的3的幂
     * @param n
     * @return
     */
    public static boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


    public static void main(String[] args) {
//        System.out.println(isPowerOfThree(27));
//        System.out.println(isPowerOfThree(-3));
        System.out.println(1162261467 % -3);

//        int max = Integer.MAX_VALUE / 3;
//        int i = 1;
//        while (i <= max){
//            i = i * 3;
//        }
//        System.out.println(i);

    }

}
