package multiThreadCore.L02;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class VolatileCannotStop {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(8);
        Producer producer = new Producer(blockingQueue);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(2000);

        Consumer consumer = new Consumer(blockingQueue);
//        while (consumer.needMoreNums()) {
//            System.out.println(consumer.storage.take() + "被消费了");
//            Thread.sleep(100);
//        }

//        System.out.println("消费者不需要更多数据了");
        //一旦消费者不需要更多数据了 我们需要生产者也停下来 实际情况却停不下来
        //canceled值虽然变了，但是生产者无法感知到，它处于阻塞状态
//        System.out.println(consumer.storage.take() + "被消费了");
//        producer.canceled = true;
//        System.out.println(consumer.storage.take() + "被消费了");
        /*
        * 消费者consumer.storage.take()时，内部会触发唤醒。
        * 方法源码：
        * public E take() throws InterruptedException {
        *  final ReentrantLock lock = this.lock; lock.lockInterruptibly();
        * try { while (count == 0) notEmpty.await(); return dequeue(); }
        * finally { lock.unlock(); } }
        * */

        producerThread.interrupt();
//        System.out.println(producer.canceled);
    }
}
