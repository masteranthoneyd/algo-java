package com.yangbingdong.algo.basic.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> res = permutations.permute(nums);
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteInner(nums, nums.length, res, 0);
        return res;
    }

    private void permuteInner(int[] nums, int n, List<List<Integer>> res, int first) {
        if (first == n) {
            List<Integer> r = new ArrayList<>();
            for (int num : nums) {
                r.add(num);
            }
            res.add(r);
            return;
        }
        for (int i = first; i < n; i++) {
            swap(nums, first, i);
            permuteInner(nums, n, res, first + 1);
            swap(nums, first, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
