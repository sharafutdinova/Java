package practice.string_tasks;

public class StringModifications {
    static void main(String[] args) {
        checkIntern();
        stringConcat();
        stringBuilder();
    }

    public static void checkIntern() {
        String z = new String("test").intern();//intern() возвращает строку из пула
        String y = "test";
        System.out.println(z == y);//true

        String n = "x";
        n = n + 1;
        n.intern();
        System.out.println(n == "x1");//true

        String s = "x";
        for (int i = 0; i < 2; i++) {
            s = s + i;
            s.intern();
        }
        System.out.println(s == "x0" + "1");//true
    }

    public static void stringConcat() {
        String a = "x";
        for (int i = 0; i < 3; i++) {
            a += i;
        }
        System.out.println(a == "x012");//false
        System.out.println(a.equals("x012"));//true

        String e = "b1" + "23"; // конкатенация констант во время компиляции
        System.out.println(e == "b123"); // true, т.к. это тоже литерал

        String b = "b1";
        b += "23";//b = new StringBuilder().append(b).append("23").toString(). Метод toString() создаёт новый объект String в куче (heap), который не попадает автоматически в пул строк.
        System.out.println(b == "b123");//false b ссылается на объект в куче, а литерал "b123" – на объект в пуле
        System.out.println(b.equals("b123")); //true

        String a1 = "a";
        String b1 = a1 + "b";
        String c1 = "a" + "b";
        System.out.println(b1 == "ab");//false В выражении `a1 + "b"` участвует переменная, результат — новый объект.
        System.out.println(c1 == "ab");//true Литералы компилируются в пул.
    }

    public static void stringBuilder() {
        String c = "c1";
        c = "c123";
        System.out.println(c == "c123");//true сравнение ссылок в куче
        System.out.println(c.equals("c123")); //true

        String f = new String("b123");
        System.out.println(f == "b123"); // false, new создаёт новый объект в куче

        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("abc");
        System.out.println(sb1.toString() == sb2.toString());//false
    }
}
