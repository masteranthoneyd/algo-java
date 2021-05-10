package com.yangbingdong.algo.basic.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class ValidParenthesesSolutionTest {

    ValidParenthesesSolution solution;

    @BeforeEach
    void init() {
        solution = new ValidParenthesesSolution();
    }

    @Test
    void testValidParentheses1() {
        String s = "()";
        assertTrue(solution.isValid(s));
    }

    @Test
    void testValidParentheses2() {
        String s = "()[]{}";
        assertTrue(solution.isValid(s));
    }

    @Test
    void testValidParentheses3() {
        String s = "{[]}";
        assertTrue(solution.isValid(s));
    }

    @Test
    void testValidParentheses4() {
        String s = "([)]";
        assertFalse(solution.isValid(s));
    }

    @Test
    void testValidParentheses5() {
        String s = "((";
        assertFalse(solution.isValid(s));
    }

}
