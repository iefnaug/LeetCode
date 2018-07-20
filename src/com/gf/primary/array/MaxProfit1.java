package com.gf.primary.array;
/*
 * Author guanfei
 * Date 2018/7/20
 * Coding Forever
 */

public class MaxProfit1 {

    /**
     * 暴力破解, 计算所有买卖的差值 时间复杂度O(n^2)
     * @param price
     * @return
     */
    static int maxProfit(int []price){
        if(price.length < 2){
            throw new RuntimeException("无法获取利润");
        }
        int profit = 0;
        for(int i=0; i<price.length-1; i++){
            for(int j=i+1; j<price.length; j++){
                int eachProfit = price[j] - price[i];
                if(eachProfit > profit){
                    profit = eachProfit;
                }
            }
        }
        if(profit <= 0){
            throw new RuntimeException("无法获取利润");
        }
        return profit;
    }

    /**
     * Solution2 : 动态规划， 时间复杂度O(n)
     * @param price
     * @return
     */
    static int maxProfit2(int []price){
        //1.计算股票走势
        int []trend = new int[price.length - 1];
        for(int i=0; i<price.length-1; i++){
            trend[i] = price[i+1] - price[i];
        }

        //2.计算trend的最大子序和, 动态规划: 划分成求多个区间的最大子序和
        int max = 0;
        int sum = 0;
        for(int j=0; j<trend.length; j++){
            sum = sum + trend[j];
            if(sum > max){
                max = sum;
            }else if(sum < 0){
                sum = 0;
            }
        }
        return max;

    }


    public static void main(String[] args) {
        int []price = new int[]{12, 5, 8, 6, 1, 22,55, 33};
//        int profit = maxProfit(price);
        int profit = maxProfit2(price);
        System.out.println("利润:" + profit);
    }
}
