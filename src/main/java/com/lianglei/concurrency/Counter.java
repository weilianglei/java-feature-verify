package com.lianglei.concurrency;

/**
 * 线程不安全的计数器
 * @author weilianglei
 * @date 2018-09-30
 */
public class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }
}
