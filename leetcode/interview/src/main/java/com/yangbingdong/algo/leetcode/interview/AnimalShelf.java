package com.yangbingdong.algo.leetcode.interview;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/animal-shelter-lcci/
 */
public class AnimalShelf {

    private final Queue<int[]> queue;

    public AnimalShelf() {
        queue = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        queue.offer(animal);
    }

    public int[] dequeueAny() {
        int[] poll = queue.poll();
        return poll == null ? new int[]{-1, -1} : poll;
    }

    public int[] dequeueDog() {
        Iterator<int[]> iterator = queue.iterator();
        int[] r;
        while (iterator.hasNext()) {
            r = iterator.next();
            if (r[1] == 1) {
                iterator.remove();
                return r;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] dequeueCat() {
        Iterator<int[]> iterator = queue.iterator();
        int[] r;
        while (iterator.hasNext()) {
            r = iterator.next();
            if (r[1] == 0) {
                iterator.remove();
                return r;
            }
        }
        return new int[]{-1, -1};

    }
}
