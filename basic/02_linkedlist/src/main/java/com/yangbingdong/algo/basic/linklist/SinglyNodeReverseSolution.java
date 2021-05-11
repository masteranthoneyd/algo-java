package com.yangbingdong.algo.basic.linklist;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class SinglyNodeReverseSolution {

    public <T> SNode<T> reverse(SNode<T> node) {
        if (node == null || node.next == null) {
            return node;
        }
        SNode<T> pre = null;
        SNode<T> cur = node;
        SNode<T> next = node.next;
        while (cur.next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }

    public static void main(String[] args) {
        SNode<String> n1 = new SNode<>("A");
        SNode<String> n2 = new SNode<>("B");
        n1.next = n2;
        SNode<String> n3 = new SNode<>("C");
        n2.next = n3;
        SNode<String> n4 = new SNode<>("D");
        n3.next = n4;
        System.out.println(n1);

        SinglyNodeReverseSolution solution = new SinglyNodeReverseSolution();
        SNode<String> reversed = solution.reverse(n1);
        System.out.println(reversed);
    }
}
