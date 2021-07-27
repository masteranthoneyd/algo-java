package com.yangbingdong.algo.basic.strmatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class BruteForceTest {

    @Test
    void testStringMatch() {
        BruteForce bruteForce = new BruteForce();
        Assertions.assertEquals(6, bruteForce.indexOf("aaaabbbccc", "bc"));
        Assertions.assertEquals(3, bruteForce.indexOf("aaaabbbccc", "abb"));
        Assertions.assertEquals(-1, bruteForce.indexOf("aaaabbbccc", "cba"));
    }

}
