package Task_8.generics.part_3;

public class Main {
//    Условие задачи: Создайте класс Pair, который может хранить два объекта разных типов.
//    Класс должен позволять получать и устанавливать каждый из этих объектов.
    public static void main(String[] args){
        Pair<Integer, String> pair_1 = new Pair<>();
        pair_1.setKey(1);
        pair_1.setValue("one");
        System.out.println(pair_1.getKey());
        System.out.println(pair_1.getValue());
    }
}
