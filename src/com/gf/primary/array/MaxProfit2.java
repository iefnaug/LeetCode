package com.gf.primary.array;
/*
 * Author guanfei
 * Date 2018/7/18
 * Coding Forever
 *
 *
 *
    买卖股票的最佳时机 II

    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    示例 1:

    输入: [7,1,5,3,6,4]
    输出: 7
    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
         随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
    示例 2:

    输入: [1,2,3,4,5]
    输出: 4
    解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
         注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
         因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
    示例 3:

    输入: [7,6,4,3,1]
    输出: 0
    解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */

import java.util.Random;

public class MaxProfit2 {

    /**
     * 计算股票走势，只要是上涨就卖出
     * @param price
     * @return
     */
    static int maxProfit(int []price){

        if(price.length < 2){
            return 0;
        }

        //1.计算股票走势
        int []trend = new int[price.length - 1];
        for(int i=0; i<price.length-1; i++){
            trend[i] = price[i+1] - price[i];
        }

        //2.只要股票走势为上涨则卖出
        int max = 0;
        for(int j=0; j<trend.length; j++){
            if(trend[j] > 0){
                max += trend[j];
            }
        }

        return max;
    }


    public static int maxProfit2(int  []price){
        if(price.length < 2){
            return 0;
        }
        int max = 0;
        for(int i=0; i<price.length-1; i++){
            int trend = price[i+1] - price[i];
            if(trend > 0){
                max += trend;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int []price = new int[10000];

        Random random = new Random();
        for(int i=0; i<10000; i++){
            price[i] = random.nextInt(10000) - 5000;
        }

        long start = System.currentTimeMillis();
        int profit = maxProfit(price);
        long end = System.currentTimeMillis();
        System.out.println("最大利润:" + profit);
        System.out.println("耗费时间:" + (end - start));


        start = System.currentTimeMillis();
        profit = maxProfit2(price);
        end = System.currentTimeMillis();
        System.out.println("最大利润:" + profit);
        System.out.println("耗费时间:" + (end - start));
    }
}
