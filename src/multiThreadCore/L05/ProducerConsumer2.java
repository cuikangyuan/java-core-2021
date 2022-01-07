package multiThreadCore.L05;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer2 {






    public static class MyBlockingQueue2 {

        private List list;
        private int max = 16;
        private ReentrantLock lock = new ReentrantLock();
        private Condition notFull = lock.newCondition();
        private Condition notEmpty = lock.newCondition();

        public MyBlockingQueue2(int size) {
            this.max = size;
            list = new LinkedList<>();
        }

        public void put(Object object) throws InterruptedException{

            lock.lock();
            try{
                while(list.size() == max) {
                    notFull.await();
                }
                list.add(object);
                notEmpty.signalAll();
            } finally {
                lock.unlock();
            }

        }

        public Object take() throws InterruptedException {
            lock.lock();
            try {
                while(list.size() == 0) {
                    notEmpty.await();
                }
                Object object = list.remove(0);
                notFull.signalAll();
                return object;
            } finally {
                lock.unlock();
            }
        }
    }



    public static void main(String[] args) {
        MyBlockingQueue2 queue = new MyBlockingQueue2(10);

        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        queue.put(new Object());
                        System.out.println("2.producer put item ... ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("2.producer finished !!!! ");
            }
        };

        Thread pt = new Thread(producer);
        pt.start();

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                int value = 0;
                while((value = new Random().nextInt(1000)) >= 200) {
                    try {
                        queue.take();
                        System.out.println("2.consumer take item $$$ ");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pt.interrupt();
                System.out.println("2.consumer finished !!!! latch = " + value);
            }
        };

        new Thread(consumer).start();
    }

    
}
