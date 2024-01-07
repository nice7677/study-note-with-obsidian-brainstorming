package synchronised;

public class SemaphoreExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            SemaphoreSharedResource.accessResource();
        });

        Thread thread2 = new Thread(() -> {
            SemaphoreSharedResource.accessResource();
        });

        thread1.start();
        thread2.start();
    }

}
