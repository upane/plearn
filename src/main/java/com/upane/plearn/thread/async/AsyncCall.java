package com.upane.plearn.thread.async;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Description:
 * <p>
 * 1、使用wait和notify方法
 * 2、使用条件锁
 * 3、Future
 * 4、使用CountDownLatch
 * 5、使用CyclicBarrier
 *
 * @Author:pan
 * @Date:2022/5/30
 */
public class AsyncCall {

    private Random random = new Random(System.currentTimeMillis());

    private ExecutorService tp = Executors.newSingleThreadExecutor();

    //demo1,2,4,5调用方法
    public void call(BaseDemo demo) {

        new Thread(() -> {
            long res = random.nextInt(10);

            try {
                Thread.sleep(res * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            demo.callback(res);
        }).start();


    }

    //demo3调用方法
    public Future<Long> futureCall() {

        return tp.submit(() -> {
            long res = random.nextInt(10);

            try {
                Thread.sleep(res * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return res;
        });

    }

    public void shutdown() {

        tp.shutdown();

    }

}