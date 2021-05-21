package com.yangbingdong.algo.basic.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class InfixExpressionCalculatorTest {

    @Test
    void testCalcInfixExpression() {
        InfixExpressionCalculator calculator = new InfixExpressionCalculator();
        assertEquals(68, calculator.calculate("5+7*3*(2+1)"));
        assertEquals(70, calculator.calculate("5+7*3*(((2+1)-1)+1)+2"));
        assertEquals(4, calculator.calculate("1+2-3+4"));
        assertEquals(4, calculator.calculate("1+(2-3)+4"));
        assertEquals(6, calculator.calculate("4/(1+1)*(2+1)"));
        assertEquals(7, calculator.calculate("4/1+1*(2+1)"));
        assertEquals(16, calculator.calculate("9+(3-1*2)*3+8/2"));
    }

}
