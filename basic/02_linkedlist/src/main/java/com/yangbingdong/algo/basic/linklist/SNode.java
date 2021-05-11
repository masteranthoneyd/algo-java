package com.yangbingdong.algo.basic.linklist;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
public class SNode<T> {

    public SNode(T value) {
        this.value = value;
    }

    T value;

    SNode<T> next;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SNode<T> n = this;
        while (n != null) {
            sb.append(n.value);
            n = n.next;
            if (n != null) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
}
