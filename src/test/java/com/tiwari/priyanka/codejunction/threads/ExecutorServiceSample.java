package com.tiwari.priyanka.codejunction.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i<10; i++){
            executorService.execute(new Task());
        }

        System.out.println(Thread.currentThread().getName());

    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
