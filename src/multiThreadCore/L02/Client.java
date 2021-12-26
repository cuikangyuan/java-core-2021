package multiThreadCore.L02;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new StopThread());
        thread.start();

        Thread.sleep(5);
        thread.interrupt();
    }
}