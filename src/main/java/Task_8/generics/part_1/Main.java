package Task_8.generics.part_1;

import java.sql.Array;
import java.util.LinkedList;

public class Main {
//    Условие задачи: Разработайте дженерик класс Box, который может хранить объекты любого типа.
//    Класс должен иметь методы для установки и получения значения объекта, хранящегося внутри.
    public static void main(String[] args){
        Box<String> stringBox = new Box<>();
        stringBox.setValue("new value");
        System.out.println(stringBox.getValue());

        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(13);
        System.out.println(integerBox.getValue());
    }
}
