package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/reverse-integer/solution/
 */
public class ReverseNumOfInt {

    /**
     * 要注意的地方是如何判断溢出
     * 可以记录上一次反转的结果, 将本次反转的结果除以 10 再跟上一次对比, 如果不一样, 那就代表移除了
     */
    public int reverse(int x) {
        int res = 0, last = res;
        while (x != 0) {
            int temp = x % 10;
            last = res;
            res = res * 10 + temp;
            if (last != res / 10) {
                return 0;
            }
            x = x / 10;
        }
        return res;
    }

}
