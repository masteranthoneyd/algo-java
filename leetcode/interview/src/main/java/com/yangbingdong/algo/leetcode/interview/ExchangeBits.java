package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/exchange-lcci/
 */
public class ExchangeBits {

    /**
     * 交换奇偶位, 思路:
     * 全奇数位 010101....01 = 0x55555555
     * 全偶数位 101010....10 = 0xaaaaaaaa
     * 按位与 提取奇偶数位再 按位或 加回去
     */
    public int exchangeBits(int num) {
        return ((num & 0x55555555) << 1) | ((num & 0xaaaaaaaa) >> 1);
    }
}
