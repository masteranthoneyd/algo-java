package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/number-of-students-unable-to-eat-lunch/
 */
public class NumberOfStudentsUnableToEatLunch {

    public static void main(String[] args) {
        int[] a = {1, 1, 0, 0};
        int[] b = {0, 1, 0, 1};
        NumberOfStudentsUnableToEatLunch solution = new NumberOfStudentsUnableToEatLunch();
        int i = solution.countStudents(a, b);
        System.out.println(i);
    }

    /**
     * 学生无关顺序, 因为会重新排队
     * 只需要按顺序分配面包, 直到其中一类学生分完, 剩下的数量就是答案
     */
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (--count[sandwiches[i]] < 0) {
                return sandwiches.length - i;
            }
        }
        return 0;
    }
}
