package com.lianglei.concurrency;

/**
 * 不安全的计数器
 */
public class UnsafeThreadCounter {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread = new Thread(() -> iterateIncrement(counter));

        thread.start();

        iterateDecrement(counter);

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    /**
     * 循环递增计数器
     * @param counter 计数器
     */
    public static void iterateIncrement(Counter counter) {
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName()+ " before increment value = " + counter.value());
            counter.increment();
            System.out.println(Thread.currentThread().getName() + " after increment value = " + counter.value());
        }
    }

    /**
     * 循环递减 计数器
     * @param counter 计数器
     */
    public static void iterateDecrement(Counter counter) {
        for (int i = 0; i < 400; i++) {
            System.out.println(Thread.currentThread().getName()+ " before decrement value = " + counter.value());
            counter.decrement();
            System.out.println(Thread.currentThread().getName() + " after decrement value = " + counter.value());
        }
    }
}
