package practice_7.cost_counter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class CostCounter {
    private ArrayList<Double> costPerMonth;

    public CostCounter() {
        this.costPerMonth = new ArrayList<>();
    }

    public void addCost(int month, Double cost) {
        costPerMonth.add(month - 1, cost);
    }

    public Double getCost(int month) {
        return costPerMonth.get(month - 1);
    }

    public Double getMinCostMonth() {
        AtomicReference<Double> min = new AtomicReference<>(costPerMonth.getFirst());
        costPerMonth.forEach(costPerMonth -> {
            if (costPerMonth < min.get()) {
                min.set(costPerMonth);
            }
        });
        return min.get();
    }
}
