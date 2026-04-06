package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public class A1 {

        public static void print() {
            System.out.println("Static");
        }
    }

    public static void main(String... args) {
//        var a = new int[1] ;
        int[] a = new int[]{21};
//        a[0] = 21;
        Integer b = Integer.valueOf(17);
        Integer c = 100;
        List<String> list = new ArrayList<>(Arrays.asList("test"));

        inc(a);
        inc(c);
        addElement(list);
        System.out.println(a[0]);
        System.out.println(list);

//        A1 a = null;
//        a.print();
//
//        A1 b;
//        b.print();
//
//        A1 c = new A1();
//        c.print();
    }


    public static void addElement(List<String> list) {
        list.add("hey");
    }
    public static void inc(int[] a) {
        a[0]++;
    }

    public static void inc(int a) {
        a = a++;
    }

    public static void inc(Integer b) {
        b++;
    }

//        Long value = 10L;
//        switch (value) {
//            case (Long) 100L -> System.out.println("Ten");
//            case 0L -> System.out.println("Zero");
//            default -> System.out.println("Default");
//        }


//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//
//        for (String elem : list) {
//            if (elem.equals("a")) {
//                list.remove(elem);
//            }
//        }
//        System.out.println(list);

}
