package base.producer_and_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 传统生产消费模型
 *
 * 一个初始值为0的变量，两个线程交替操作，一个加一一个减一，来五轮
 *
 * 1. 线程   操作（方法）    资源类
 * 2. 判断   干活    通知
 * 3. 防止虚假唤醒机制
 *
 *
 * synchronized vs Lock
 *  1. 原理构成
 *     synchronized 关键词 JVM层面
 *          monitorenter （monitor对象）
 *          monitorexit
 *     Lock 类
 *  2. 使用方法
 *      synchronized 不需要用户手动释放锁
 *      Lock 如果不主动释放可能死锁
 *          lock()  &  unlock()
 *
 *  3. 等待是否可以中断  (lock优点)
 *      synchronized 不可以
 *      Lock 可以
 *  4. 加锁是否公平
 *      synchronized 非公平锁
 *      Lock 可以选则，创建时传入true创建公平锁，默认非公平锁
 *  5.锁绑定多个条件condition (lock优点)
 *      synchronized 没有
 *      ReentrantLock 可以用来实现分组唤醒线程，精确唤醒线程  synchronized只能随机唤醒和全部唤醒
 *
 */
public class TraditionDemo {

    public static void main(String[] a) {

        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BBB").start();



    }

}

// 资源类
class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            // 1判断
            // 防止虛假喚醒，需要while判斷狀態
            while (number != 0) {
                // 等待，不能生产
                condition.await();
            }
            // 2干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            // 1判断
            // 防止虛假喚醒，需要while判斷狀態
            while (number == 0) {
                // 等待，不能生产
                condition.await();
            }
            // 2干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
