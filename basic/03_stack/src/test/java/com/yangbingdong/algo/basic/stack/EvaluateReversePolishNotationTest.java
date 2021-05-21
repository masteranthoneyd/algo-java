package com.yangbingdong.algo.basic.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class EvaluateReversePolishNotationTest {

    @Test
    void testEval() {
        EvaluateReversePolishNotation eval = new EvaluateReversePolishNotation();
        // Assertions.assertEquals(19, eval.evalRPN("931-3*+82/+".split("")));
        // Assertions.assertEquals(68, eval.evalRPN("573*21+*+".split("")));
        Assertions.assertEquals(6, eval.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
