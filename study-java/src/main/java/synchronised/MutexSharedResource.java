package synchronised;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexSharedResource {

    private static Lock mutex = new ReentrantLock();

    public static void accessResource() {
        mutex.lock();
        // critical section - 임계 영역
        try {
            System.out.println(Thread.currentThread().getName() + " 스레드가 임계영역에 있음.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.unlock();
        }
    }

}
