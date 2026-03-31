package Task_10.part_1;

public class Main {
    static void main(String[] args) {
//        Условие задачи: Напишите программу, в которой создается отдельный поток, выводящий сообщение "Привет из потока!"
//        5 раз с паузой в 1 секунду между сообщениями.
        Thread threadPrintHello = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Привет из потока!");
            }
        });
        threadPrintHello.start();
    }
}
