package practice_7.restaurant_manager;

import java.util.LinkedList;

public class RestaurantManager {
    private LinkedList<String> orders;

    public RestaurantManager() {
        orders = new LinkedList<>();
    }

    public void addOrder(String order) {
        orders.addLast(order);
    }

    public String getNextOrder() {
        return orders.poll();
    }

    public void deleteOrder(String order) {
        orders.remove(order);
    }

    public void printOrders() {
        orders.forEach(System.out::println);
        System.out.println();
    }
}
