package com.yangbingdong.algo.basic.strmatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class RabinKarpTest {

    @Test
    void testStringMatch() {
        RabinKarp rabinKarp = new RabinKarp();
        Assertions.assertEquals(6, rabinKarp.indexOf("aaaabbbccc", "bc"));
        Assertions.assertEquals(3, rabinKarp.indexOf("aaaabbbccc", "abb"));
        Assertions.assertEquals(-1, rabinKarp.indexOf("aaaabbbccc", "cba"));
    }

}
