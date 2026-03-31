package Task_8.generics_additional;

public class ContainterClass<T> implements Container<T> {
    private T item;

    public void add(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}
