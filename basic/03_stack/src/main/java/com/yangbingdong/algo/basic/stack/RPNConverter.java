package com.yangbingdong.algo.basic.stack;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 将中缀表达式转换成后缀表达式(逆波兰表达式), 只需要一个栈就能实现
 * 核心思路: 遍历字符
 * 1. 数字直接输出
 * 2. 遇到操作符, 当满足(栈不为空并且栈顶元素不是左括号并且栈顶元素优先级大于等于这个操作符)的时候, 弹出栈顶操作符并输出, 直到不满足, 入栈
 * 3. 如果是左括号, 入栈
 * 4. 如果是右括号, 输出栈顶元素, 直到遇到左括号
 * 5. 字符遍历完成, 最后, 如果栈不为空, 直接依次弹出栈元素
 */
public class RPNConverter {

    public String convert(String expression) {
        StringBuilder sb = new StringBuilder(expression.length());
        Stack<String> stack = new ArrayStack<>();
        for (String s : expression.split("")) {
            if (RPNUtil.isNum(s)) {
                sb.append(s);
                continue;
            }
            if (RPNUtil.isOp(s)) {
                while (!stack.isEmpty() && !"(".equals(stack.peek()) && RPNUtil.getOpWeight(s) <= RPNUtil.getOpWeight(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(s);
                continue;
            }
            if ("(".equals(s)) {
                stack.push(s);
                continue;
            }
            if (")".equals(s)) {
                String t;
                while (!"(".equals(t = stack.pop())) {
                    sb.append(t);
                }
                continue;
            }
            throw new IllegalArgumentException();
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
