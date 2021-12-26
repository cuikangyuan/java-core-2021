package multiThreadCore.L02;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    public volatile boolean canceled = false;
    BlockingQueue storage;

    public Producer(BlockingQueue blockingQeque) {
        this.storage = blockingQeque;
    }

    @Override
    public void run() {
        int num = 0;

        try {
            while ((!canceled || !Thread.currentThread().isInterrupted())&& num < 1000000) {
                if (num % 50 == 0) {
                    storage.put(num);
                    System.out.println(num + "是50的倍数，放入仓库中");
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("==============================>生产者结束运行");
        }
    }
}
