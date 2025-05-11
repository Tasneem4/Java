package com.tnsif.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private List<FoodItem> menu;

    // Constructor
    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    // Add a FoodItem to menu
    public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    // Remove a FoodItem by its ID
    public void removeFoodItem(int foodItemId) {
        menu.removeIf(item -> item.getId() == foodItemId);
    }

    @Override
    public String toString() {
        return "Restaurant{id=" + id + ", name='" + name + "', menu=" + menu + '}';
    }
}
