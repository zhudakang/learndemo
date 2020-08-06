package com.dk.learndemo.meet;

/**
 * @author :zhudakang
 * @description : SyncThread2
 * @create : 2020/08/06
 */
public class SyncThread2 implements Runnable {

    private static int count;

    public SyncThread2() {
        count = 0;
    }

    /**
     * 静态方法是属于类的而不属于对象的。
     * 同样的，synchronized修饰的静态方法锁定的是这个类的所有对象。
     * */
    public synchronized static void method() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void run() {
        method();
    }

    public static void main(String args[]) {
        SyncThread2 syncThread1 = new SyncThread2();
        SyncThread2 syncThread2 = new SyncThread2();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
