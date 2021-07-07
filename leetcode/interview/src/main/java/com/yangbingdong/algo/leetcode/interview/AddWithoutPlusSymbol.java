package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/add-without-plus-lcci/
 */
public class AddWithoutPlusSymbol {

    /**
     * 位异或得到不进位结果, 按位与左移以为得到进位结果,
     * 当进位结果不为 0, 继续与上一轮位异或的结果进行位异或
     */
    public int add(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        AddWithoutPlusSymbol solution = new AddWithoutPlusSymbol();
        int res = solution.add(0, 0);
        System.out.println(res);
    }

}
