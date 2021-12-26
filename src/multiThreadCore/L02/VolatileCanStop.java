package multiThreadCore.L02;

public class VolatileCanStop implements Runnable {

    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (!canceled && num < 1000) {
                System.out.println(num++);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCanStop volatileCanStop = new VolatileCanStop();
        Thread thread = new Thread(volatileCanStop);
        thread.start();
        Thread.sleep(300);
        volatileCanStop.canceled = true;
    }
}
