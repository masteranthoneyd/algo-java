package com.yangbingdong.algo.basic.sort;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 桶排序
 */
@AllArgsConstructor
public class BucketSort implements Sort {

    @Setter
    private int bucketSize = 5;

    @Override
    public int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        // 找出最小与最大值
        int min = nums[0], max = nums[1];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        // 构建桶
        int bucketCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];

        // 放入桶中
        for (int i = 0; i < nums.length; i++) {
            int bucketIndex = (nums[i] - min) / bucketSize;
            if (buckets[bucketIndex].length == indexArr[bucketIndex]) {
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = nums[i];
        }

        // 每个桶使用快排
        QuickSort sort = new QuickSort();
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0) {
                continue;
            }
            sort.sort(buckets[i]);
            for (int j = 0; j < buckets[i].length; j++) {
                nums[k++] = buckets[i][j];
            }
        }

        return nums;
    }

    protected void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] bucket = buckets[bucketIndex];
        int[] newBucket = new int[bucket.length * 2];
        System.arraycopy(bucket, 0, newBucket, 0, bucket.length);
        buckets[bucketIndex] = newBucket;
    }

}
