package com.yangbingdong.algo.basic.stack;

import java.util.Deque;
import java.util.LinkedList;

import static com.yangbingdong.algo.basic.stack.RPNUtil.getOpWeight;
import static com.yangbingdong.algo.basic.stack.RPNUtil.isNum;
import static com.yangbingdong.algo.basic.stack.RPNUtil.isOp;


/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 需要两个栈, 一个操作数栈(存放数字, 下面用 nums 表示), 一个操作符栈(存加减乘除以及括号, 下面用 ops 表示)
 * 遍历表达式:
 * 1. 如果是数字, 直接压入 nums
 * 2. 如果是操作符
 *    1. 如果 ops 为空, 或者优先级比 ops 栈顶的操作符高, 又或者是左括号, 压入 ops
 *    2. 否则弹出 ops 栈顶元素, nums 弹出两个元素放置操作符右侧与左侧运算(注意顺序, 第一个弹出的放右边), 结果压入 nums, 然后再重复直到2.1 成立
 * 3. 如果是括号
 *    1. 左括号直接压入 ops
 *    2. 遇到右括号, 依次弹出 ops 栈顶操作符, 与 nums 的两个弹出的两个数字运算后(注意顺序, 第一个弹出的数字在右边)结果压入 nums, 直到遇到左括号
 * 4. 表达式遍历完毕, ops 中至少还会有一个操作符, 依次弹出与 nums 弹出的两个数字运算, 结果压入 nums, 直到 ops 为空
 * 5. 返回 nums 的栈顶元素.
 */
public class InfixExpressionCalculator {

    public int calculate(String expresion) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<String> ops = new LinkedList<>();
        for (String s : expresion.split("")) {
            if (isNum(s)) {
                nums.push(Integer.valueOf(s));
            }
            if (isOp(s)) {
                if (ops.isEmpty()) {
                    ops.push(s);
                } else {
                    String opInStack = ops.peek();
                    while (opInStack != null && !"(".equals(opInStack) &&
                            getOpWeight(opInStack) >= getOpWeight(s)) {
                        String op = ops.pop();
                        Integer right = nums.pop();
                        Integer left = nums.pop();
                        Integer tmp = RPNUtil.calculate(left, right, op);
                        nums.push(tmp);
                        opInStack = ops.isEmpty() ? null : ops.peek();
                    }
                    ops.push(s);
                }
            }
            if ("(".equals(s)) {
                ops.push(s);
            }
            if (")".equals(s)) {
                String op;
                while (!ops.isEmpty() && !"(".equals(op = ops.pop())) {
                    Integer right = nums.pop();
                    Integer left = nums.pop();
                    Integer tmp = RPNUtil.calculate(left, right, op);
                    nums.push(tmp);
                }
            }
        }
        String op;
        while (!ops.isEmpty()) {
            op = ops.pop();
            Integer right = nums.pop();
            Integer left = nums.pop();
            Integer tmp = RPNUtil.calculate(left, right, op);
            nums.push(tmp);
        }
        return nums.pop();
    }


}
