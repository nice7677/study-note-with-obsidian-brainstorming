package synchronised;

import java.util.concurrent.Semaphore;

public class SemaphoreSharedResource {

    private static Semaphore semaphore = new Semaphore(2);

    public static void accessResource() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " 스레드가 임계영역에 있음.");
            Thread.sleep(1000); // Simulating some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

}
