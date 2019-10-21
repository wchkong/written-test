package Base;

import static java.lang.Thread.sleep;

/**
 * 生产者消费者模型
 */
public class ThreadDemo {

    public static void main(String[] args) {

        CommonSource commonSource = new CommonSource();
        Producer producer = new Producer(commonSource);
        Consumer consumer = new Consumer(commonSource);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

}

class Producer implements Runnable {

    private CommonSource commonSource;

    public Producer(CommonSource commonSource) {
        this.commonSource = commonSource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            int product = (int) (Math.random() * 1000);
            commonSource.put(product);
            System.out.println("生产者生产：" + product);

            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private CommonSource commonSource;

    public Consumer(CommonSource commonSource) {
        this.commonSource = commonSource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            int product = commonSource.get();
            System.out.println("消费者消费：" + product);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class CommonSource {
    private int[] production;
    private int count;
    private static int BUFFERSIZE = 6;

    public CommonSource() {
        this.production = new int[BUFFERSIZE];
        this.count = 0;
    }

    // 从缓冲区获取数据
    public synchronized int get() {
        int result;
        // 防止虛假喚醒，需要while判斷狀態
        while (count <= 0) {
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = production[--count];
        notifyAll();
        return result;
    }

    // 向缓冲区写数据
    public synchronized void put(int product) {
        while (count >= BUFFERSIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        production[count++] = product;
        notifyAll();
    }
}