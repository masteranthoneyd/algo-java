package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            min = Math.min(price, min);
            maxProfit = Math.max(price - min, maxProfit);
        }
        return maxProfit;
    }

    public int maxProfitII(int[] prices) {
        int delta = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                delta += prices[i] - prices[i - 1];
            }
        }
        return delta;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        MaxProfit solution = new MaxProfit();
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);

    }

}
