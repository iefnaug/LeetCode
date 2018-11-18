package com.gf.leetcode.queue;

/*
 * Author guanfei
 * Date 2018/11/9
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {

    /**
     * 使用DP(动态规划)求解， dp[i]表示数字i的完全平方数个数
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=0; i<dp.length; i++) { //i 最多由 i个完全平方数1组成
            dp[i] = i;
        }
        for(int i=0; i<n; i++){
            for(int j=1; i+j*j <= n; j++){
                dp[i+j*j] = Math.min(dp[i+j*j], dp[i] + 1);
            }
        }
        return dp[n];
    }

    /**
     * dp[0] = 0
     * dp[1] = dp[0]+1 = 1
     * dp[2] = dp[1]+1 = 2
     * dp[3] = dp[2]+1 = 3
     * dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
     *       = Min{ dp[3]+1, dp[0]+1 }
     *       = 1
     * dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
     *       = Min{ dp[4]+1, dp[1]+1 }
     *       = 2
     * 						.
     * 						.
     * 						.
     * dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
     *        = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
     *        = 2
     * 						.
     * 						.
     * 						.
     * dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     * @param n
     */
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares squares = new PerfectSquares();
        int nums = squares.numSquares(125);
        System.out.println(nums);
    }
}
