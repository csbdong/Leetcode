package 面试._xiaomi2;

import java.util.concurrent.Semaphore;

public class Solution {
    static volatile int count = 0;

    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (count > 100) {
                        break;
                    }
                    try {
                        semaphore1.acquire(1);
                        System.out.println(count);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    count++;
                    semaphore2.release(1);


                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (count > 100) {
                        break;
                    }
                    try {
                        semaphore2.acquire(1);
                        System.out.println(count);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    count++;
                    semaphore1.release(1);


                }
            }
        });

        t1.start();
        t2.start();
    }
}
