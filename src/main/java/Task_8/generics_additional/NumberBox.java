package Task_8.generics_additional;

import java.util.LinkedList;

public class NumberBox<T extends Number> {
    private LinkedList<T> list;

    public NumberBox() {
        list = new LinkedList<>();
    }

    public void addNumber(T number) {
        list.add(number);
    }

    public Double getSum() {
        Double sum = 0.0;
        for (T num : list) {
            sum = sum + num.doubleValue();
        }
        return sum;
    }

}
