package com.gf.primary.string;

/**
 * Author gf
 * Date 2018/9/18.
 * Coding Forever
 *
 *
 *
 *
 *
 示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class Reverse {

    public static int reverse(int x) {
        int reverseInt = 0;
        boolean positive = true;
        if(x < 0){
            if(x == Integer.MIN_VALUE) return 0;
            x = -x;
            positive = false;
        }

        int maxDevide10 = Integer.MAX_VALUE / 10;
        int num = Integer.MAX_VALUE - maxDevide10 * 10;

        while(x > 0){
            int position = x - x/10 * 10;
            x /= 10;
            if(position == 0 && reverseInt == 0){
                continue;
            }
            if(maxDevide10 > reverseInt){
                reverseInt = reverseInt * 10 + position;
            }else if(maxDevide10 == reverseInt){
                if(num < position) return 0;
                reverseInt = reverseInt * 10 + position;
            }else{
                return 0;
            }
        }
        return positive ? reverseInt : -reverseInt;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1463847412));
        System.out.println(Integer.MAX_VALUE);
    }
}
