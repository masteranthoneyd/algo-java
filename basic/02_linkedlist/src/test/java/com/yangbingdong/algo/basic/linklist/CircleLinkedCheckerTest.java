package com.yangbingdong.algo.basic.linklist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class CircleLinkedCheckerTest {

    CircleLinkedChecker circleLinkedChecker;

    @BeforeEach
    void init() {
        circleLinkedChecker = new CircleLinkedChecker();
    }

    @Test
    void testCheckCircle_givenSingleNode() {
        SNode<String> node = new SNode<>("0");
        assertFalse(circleLinkedChecker.check(node));
    }

    @Test
    void testCheckCircle_givenNodeWithSize2() {
        SNode<String> node = buildSNode(2, false);
        assertFalse(circleLinkedChecker.check(node));
    }

    @Test
    void testCheckCircle_givenNodeWithSize3() {
        SNode<String> node = buildSNode(3, false);
        assertFalse(circleLinkedChecker.check(node));
    }

    @Test
    void testCheck_givenCircleNodeWithSize4() {
        SNode<String> node = buildSNode(4, false);
        assertFalse(circleLinkedChecker.check(node));
    }

    @Test
    void testCheckCircle_givenCircleNodeWithSize2() {
        SNode<String> node = buildSNode(2, true);
        assertTrue(circleLinkedChecker.check(node));
    }

    @Test
    void testCheckCircle_givenCircleNodeWithSize3() {
        SNode<String> node = buildSNode(3, true);
        assertTrue(circleLinkedChecker.check(node));
    }

    @Test
    void testCheckCircle_givenCircleNodeWithSize4() {
        SNode<String> node = buildSNode(4, true);
        assertTrue(circleLinkedChecker.check(node));
    }

    SNode<String> buildSNode(int num, boolean circle) {
        assert num > 1;
        SNode<String> head = new SNode<>("0");
        SNode<String> node = head;
        for (int i = 1; i < num; i++) {
            node.next = new SNode<>(String.valueOf(i));
            node = node.next;
        }
        if (circle) {
            node.next = head;
        }
        return head;
    }
}
