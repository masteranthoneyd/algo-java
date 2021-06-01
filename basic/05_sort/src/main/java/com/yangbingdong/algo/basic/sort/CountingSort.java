package com.yangbingdong.algo.basic.sort;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 计数排序
 */
public class CountingSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        // 1. 找出数组最小与最大值
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        // 2. 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];

        // 3. 计算每个元素的个数，放入c中
        for (int i = 0; i < nums.length; i++) {
            c[nums[i]]++;
        }

        // 4. 依次累加, 得到的结果是, 大于等于当前下标的元素个数
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }

        // 5. 临时数组r，存储排序之后的结果
        int[] r = new int[nums.length];

        for (int i = nums.length - 1; i >=0 ; i--) {
            int num = nums[i];
            int index = c[num] - 1;
            r[index] = num;
            c[num]--;
        }

        System.arraycopy(r, 0, nums, 0, nums.length);

        return nums;
    }

}
