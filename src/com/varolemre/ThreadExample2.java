package com.varolemre;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadExample2 {
    public static void main(String[] args) {
        AtomicInteger deger = new AtomicInteger(10);

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            deger.getAndIncrement();
            System.out.println("Hello " +deger+" "+ threadName);
        };


        Thread thread = new Thread(task);
        thread.start();

        ExecutorService executor = Executors.newCachedThreadPool();
        IntStream.range(0, 9).forEach(i -> executor.submit(task));
    }

}




