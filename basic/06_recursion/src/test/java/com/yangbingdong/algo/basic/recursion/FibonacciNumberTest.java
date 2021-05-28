package com.yangbingdong.algo.basic.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class FibonacciNumberTest {

    FibonacciNumber fibonacci;

    @BeforeEach
    void init() {
        fibonacci = new FibonacciNumber();
    }

    @Test
    void testFibonacciNumber() {
        assertEquals(1, fibonacci.fib(2));
        assertEquals(2, fibonacci.fib(3));
        assertEquals(3, fibonacci.fib(4));
    }

}
