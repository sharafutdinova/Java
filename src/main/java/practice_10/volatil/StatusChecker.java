package practice_10.volatil;

public class StatusChecker implements Runnable {
    private volatile boolean active = true;

    @Override
    public void run() {
        while (active) {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        this.active = false;
    }
}
