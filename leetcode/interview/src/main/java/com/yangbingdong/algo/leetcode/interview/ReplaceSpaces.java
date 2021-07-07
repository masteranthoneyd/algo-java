package com.yangbingdong.algo.leetcode.interview;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/string-to-url-lcci/submissions/
 */
public class ReplaceSpaces {

    /**
     * 倒序遍历, 将结果存在数组
     */
    public String replaceSpaces(String S, int length) {
        if (length == 0) {
            return "";
        }
        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }
        return new String(chars, index + 1, chars.length - 1 - index);
    }

    public String replaceSpaces1(String S, int length) {
        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            //如果遇到空格就把他转化为"%20"
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }
        return new String(chars, index + 1, chars.length - index - 1);
    }

    /**
     * 使用额外的空间
     */
    public String replaceSpaces2(String S, int length) {
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
