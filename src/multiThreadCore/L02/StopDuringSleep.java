package multiThreadCore.L02;

public class StopDuringSleep {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    int num = 0;
                    while (!Thread.currentThread().isInterrupted() && num < 1000) {
                        System.out.println("num = " + num++);
                        Thread.sleep(1000000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }
}
