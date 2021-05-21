package com.yangbingdong.algo.basic.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class RPNConverterTest {

    @Test
    void testRPNConverter() {
        RPNConverter converter = new RPNConverter();
        Assertions.assertEquals("931-3*+82/+", converter.convert("9+(3-1)*3+8/2"));
        Assertions.assertEquals("573*21+*+", converter.convert("5+7*3*(2+1)"));
    }
}
