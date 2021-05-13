package com.yangbingdong.algo.leetcode.bttbass;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * LeetCode 121 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSaleStock_01 {

    public int maxProfit(int[] prices) {
        return maxProfitInner2(prices);
    }

    /**
     * 暴力破解, 会超时
     * 时间复杂度 O(n^2)
     */
    private int maxProfitInner1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    /**
     * 一次遍历, 记录买入的最小值, 遍历过程计算利润, 并更新记录利润最大值
     */
    private int maxProfitInner2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 买入的最小价格
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            minPrice = Math.min(prices[i], minPrice);
        }
        return maxProfit;
    }


}
