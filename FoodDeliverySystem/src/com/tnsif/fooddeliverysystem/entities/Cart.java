package com.tnsif.fooddeliverysystem.entities;



import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<FoodItem, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    // Add a food item to the cart
    public void addItem(FoodItem foodItem, int quantity) {
        items.put(foodItem, items.getOrDefault(foodItem, 0) + quantity);
    }

    // Remove a food item from the cart
    public void removeItem(FoodItem foodItem) {
        items.remove(foodItem);
    }

    // Return all cart items
    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" +
               "items=" + items +
               '}';
    }
}

