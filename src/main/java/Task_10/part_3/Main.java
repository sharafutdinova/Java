package Task_10.part_3;

public class Main {
    public static int counter = 0;
    public static volatile boolean stop = false;

    static void main(String[] args) throws InterruptedException {
//        Условие задачи: Создайте поток, который бесконечно увеличивает счетчик.
//                В основном потоке через 2 секунды установите флаг stop = true, чтобы остановить поток.
        Thread t1 = new Thread(() -> {
            while (!stop) {
                counter++;
            }
        });
        t1.start();
        Thread.sleep(2000);
        stop = true;
        System.out.println("Поток завершился, значение каунтера = " + counter);
    }
}
