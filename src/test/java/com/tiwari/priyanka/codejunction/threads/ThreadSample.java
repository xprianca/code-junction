package com.tiwari.priyanka.codejunction.threads;

public class ThreadSample {

    public static void main(String[] args) {
        for(int i = 0 ;i < 20; i ++){
            Thread thread = new Thread(new Task());
            thread.start();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
