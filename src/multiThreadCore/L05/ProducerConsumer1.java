package multiThreadCore.L05;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer1 {


    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue<>(10);

        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        queue.put(new Object());
                        System.out.println("producer put item ... ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("producer finished !!!! ");
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
                        System.out.println("consumer take item $$$ ");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pt.interrupt();
                System.out.println("consumer finished !!!! latch = " + value);
            }
        };

        new Thread(consumer).start();
    }
}
