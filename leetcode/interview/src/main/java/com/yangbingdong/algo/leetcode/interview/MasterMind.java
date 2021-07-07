package com.yangbingdong.algo.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/master-mind-lcci/
 */
public class MasterMind {

    public int[] masterMind(String solution, String guess) {
        int bingo = 0, fakeBingo = 0;
        List<Character> t1 = new ArrayList<>(), t2 = new ArrayList<>();
        for (int i = 0; i < solution.length(); i++) {
            char s = solution.charAt(i), g = guess.charAt(i);
            if (s != g) {
                t1.add(s);
                t2.add(g);
            } else {
                bingo++;
            }
        }
        if (t1.size() > 0) {
            for (int i = 0; i < t1.size(); i++) {
                Character character = t1.get(i);
                if (t2.contains(character)) {
                    fakeBingo++;
                    t2.remove(character);
                }
            }
        }
        return new int[]{bingo, fakeBingo};
    }
}
