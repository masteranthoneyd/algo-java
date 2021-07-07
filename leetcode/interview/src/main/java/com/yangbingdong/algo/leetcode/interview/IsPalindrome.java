package com.yangbingdong.algo.leetcode.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        a.next = b;
        ListNode c = new ListNode(2);
        b.next = c;
        ListNode d = new ListNode(1);
        c.next = d;
        IsPalindrome solution = new IsPalindrome();
        boolean palindrome = solution.isPalindrome3(a);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        while (head != null) {
            temp.add(head.val);
            head = head.next;
        }
        int left = 0, right = temp.size() - 1;
        while (left < right) {
            if (temp.get(left).equals(temp.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 使用栈
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode node = head;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        node = head;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < length / 2) {
            stack.push(node.val);
            node = node.next;
            index++;
        }
        if (length % 2 != 0) {
            node = node.next;
        }
        while (node != null) {
            if (stack.pop() != node.val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    /**
     * 反转链表对比, 如果是回文, 那么反转后与反转前是一样的
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        ListNode reverse = reverse(head);
        for (Integer i : list) {
            if (reverse.val != i) {
                return false;
            }
            reverse = reverse.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode node = head, prev = null, next;
        while (node.next != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        node.next = prev;
        return node;
    }

    /**
     * 找中点的同时反转前半的链表, 再对比
     */
    public boolean isPalindrome3(ListNode head) {
        ListNode s = head, f = head, pre = null;
        while (f != null && f.next != null) {
            f = f.next.next;

            ListNode t = s.next;
            s.next = pre;
            pre = s;
            s = t;
        }
        if (f != null) {
            s = s.next;
        }
        while (s != null) {
            if (pre.val != s.val) {
                return false;
            }
            pre = pre.next;
            s = s.next;
        }
        return true;
    }

    public boolean isPalindrome4(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }



    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
