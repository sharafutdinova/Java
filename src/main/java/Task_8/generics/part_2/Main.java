package Task_8.generics.part_2;

public class Main {
    //    Условие задачи: Напишите дженерик метод printArray, который принимает массив элементов любого типа
//    и выводит каждый элемент массива на консоль.
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana", "Orange"};
        Integer[] numbers = {1,3,5,7,9};
        printArray(fruits);
        printArray(numbers);
    }

    public static <T> void printArray(T[] array) {
        int length = array.length;
        for(int i = 0; i < length; i++){
            System.out.println(array[i]);
        }
    }
}
