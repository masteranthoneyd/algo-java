package com.yangbingdong.algo.leetcode.offer;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length * 3];
        int size = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                newChars[size++] = '%';
                newChars[size++] = '2';
                newChars[size++] = '0';
            } else {
                newChars[size++] = chars[i];
            }
        }
        return new String(newChars, 0, size);
    }
}
