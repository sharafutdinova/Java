package practice_7.cost_counter;

public class Main {
    public static void main(String[] args) {
        CostCounter costCounter = new CostCounter();
        costCounter.addCost(1, 1203.3);
        costCounter.addCost(2, 1323.3);
        costCounter.addCost(3, 193.3);
        costCounter.addCost(4, 453.3);
        costCounter.addCost(5, 673.3);
        costCounter.addCost(6, 343.3);
        System.out.println(costCounter.getCost(2));
        System.out.println(costCounter.getMinCostMonth());
    }
}
