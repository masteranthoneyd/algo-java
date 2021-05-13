package com.yangbingdong.algo.leetcode.bttbass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class BestTimeToBuyAndSaleStock_01Test {

    BestTimeToBuyAndSaleStock_01 solution;

    @BeforeEach
    void init() {
        solution = new BestTimeToBuyAndSaleStock_01();
    }

    @Test
    void testMaxProfit1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maxProfit(prices);
        Assertions.assertEquals(5, maxProfit);
    }

    @Test
    void testMaxProfit2() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        int maxProfit = solution.maxProfit(prices);
        Assertions.assertEquals(0, maxProfit);
    }
}
