package com.gxitsky;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @name: ThreadSemaphore
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-11 16:35
 **/
public class ThreadSemaphore {

    /**
     * Semaphore也是一个线程同步的辅助类，可以维护当前访问自身的线程个数，并提供了同步机制。
     * 使用Semaphore可以控制同时访问资源的线程个数。
     * acquire()尝试获取许可证，没有获得的线程会阻塞
     * release(）操作完之后释放资源到资源池中
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        final CountDownLatch latch = new CountDownLatch(20);
        // 模拟20个客户端访问
        for (int i = 0; i < 20; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semp.acquire();
                        synchronized (latch) {
                            Thread.currentThread().setName("Thread--" + latch.getCount());
                            latch.countDown();
                        }
                        Thread.sleep(4000);
                        System.out.println(Thread.currentThread().getName() + "is working");
                        semp.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        exec.shutdown();
        latch.await();
        System.out.println("---work is done----");
    }
}