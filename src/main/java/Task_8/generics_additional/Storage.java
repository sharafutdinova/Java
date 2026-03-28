package Task_8.generics_additional;

public class Storage<T> {
    private T someValue;

    public void setSomeValue(T newValue) {
        this.someValue = newValue;
    }

    public T getSomeValue() {
        return someValue;
    }
}
