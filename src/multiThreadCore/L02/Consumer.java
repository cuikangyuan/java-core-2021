package multiThreadCore.L02;

import java.util.concurrent.BlockingQueue;

public class Consumer {
    BlockingQueue storage;
    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        if (Math.random() > 0.6) {
            return false;
        }

        return true;
    }
}
