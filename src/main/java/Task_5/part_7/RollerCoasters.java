package Task_5.part_7;

public class RollerCoasters extends Attraction {
    public RollerCoasters(String description) {
        super(description);
    }

    @Override
    public void maintain() {
        System.out.println("проверка безопасности");
    }
}
