package practice_7.restaurant_manager;

public class Main {
    public static void main(String[] args) {
        RestaurantManager restaurantManager = new RestaurantManager();
        restaurantManager.addOrder("Cheescake");
        restaurantManager.addOrder("Juice");
        restaurantManager.addOrder("Pizza");
        restaurantManager.addOrder("Burger");
        restaurantManager.printOrders();
        restaurantManager.getNextOrder();
        restaurantManager.printOrders();
        restaurantManager.deleteOrder("Pizza");
        restaurantManager.printOrders();
    }
}
