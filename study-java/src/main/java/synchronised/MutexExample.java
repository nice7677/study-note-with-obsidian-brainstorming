package synchronised;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> MutexSharedResource.accessResource());
        Thread thread2 = new Thread(() -> MutexSharedResource.accessResource());

        thread1.start();
        thread2.start();
    }

}
