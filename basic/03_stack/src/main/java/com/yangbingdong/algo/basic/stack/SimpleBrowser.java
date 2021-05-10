package com.yangbingdong.algo.basic.stack;

import lombok.Getter;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * 基于栈实现的简单浏览器
 */
public class SimpleBrowser {

    private final Stack<String> forwardStack;
    private final Stack<String> fallbackStack;

    @Getter
    private String curUrl;

    public SimpleBrowser() {
        fallbackStack = new ArrayStack<>();
        forwardStack = new ArrayStack<>();
    }

    public void open(String url) {
        if (curUrl != null) {
            fallbackStack.push(curUrl);
        }
        forwardStack.clean();
        show(url);
    }

    public void forward() {
        if (!canForward()) {
            throw new IllegalArgumentException();
        }
        fallbackStack.push(curUrl);
        show(forwardStack.pop());
    }

    public void fallback() {
        if (!canFallback()) {
            throw new IllegalArgumentException();
        }
        forwardStack.push(curUrl);
        show(fallbackStack.pop());
    }

    public boolean canForward() {
        return !forwardStack.isEmpty();
    }

    public boolean canFallback() {
        return !fallbackStack.isEmpty();
    }

    protected void show(String url) {
        curUrl = url;
        System.out.println(url);
    }
}
