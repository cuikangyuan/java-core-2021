package multiThreadCore.L05;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class ProducerConsumer3 {


    public static class MyBlockingQueue3 {

        private List list;
        private int max = 16;
    

        public MyBlockingQueue3(int size) {
            this.max = size;
            list = new LinkedList<>();
        }

        public synchronized void put(Object object) throws InterruptedException{
            while(list.size() == max) {
                wait();
            }
            list.add(object);
            notifyAll();

        }

        public synchronized Object take() throws InterruptedException {
            while(list.size() == 0) {
                wait();
            }
            Object object = list.remove(0);
            notifyAll();
            return object;
        }
    }


    public static void main(String[] args) {
        MyBlockingQueue3 queue = new MyBlockingQueue3(5);

        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        queue.put(new Object());
                        System.out.println("3.producer put item ... ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("3.producer finished !!!! ");
            }
        };

        Thread pt = new Thread(producer);
        pt.start();

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                int value = 0;
                while((value = new Random().nextInt(1000)) >= 100) {
                    try {
                        queue.take();
                        System.out.println("3.consumer take item $$$ ");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pt.interrupt();
                System.out.println("3.consumer finished !!!! latch = " + value);
            }
        };

        new Thread(consumer).start();
    }
}
