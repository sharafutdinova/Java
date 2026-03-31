package Task_10.part_2;

public class Main {
    static void main(String[] args) {
//        Условие задачи: Создайте два потока. Один поток должен печатать "A", второй — "B", каждый по 5 раз с небольшой задержкой.
        Thread threadPrintA = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("A");
            }
        });
        Thread threadPrintB = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("B");
            }
        });
        threadPrintA.start();
        threadPrintB.start();
    }
}
