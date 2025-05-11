package com.tnsif.fooddeliverysystem.services;



import java.util.ArrayList;
import java.util.List;
import com.tnsif.fooddeliverysystem.entities.FoodItem;
import com.tnsif.fooddeliverysystem.entities.Restaurant;

public class FoodService {
    private List<Restaurant> restaurants = new ArrayList<>();

    // Add a new restaurant
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    // Get all restaurants
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    // Get all food items from all restaurants
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> allFoodItems = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            allFoodItems.addAll(restaurant.getMenu());
        }
        return allFoodItems;
    }

    // Add a food item to a specific restaurant
    public void addFoodItemToRestaurant(int restaurantId, FoodItem foodItem) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == restaurantId) {
                restaurant.addFoodItem(foodItem);
                return;
            }
        }
    }

    // Remove a food item from a specific restaurant
    public void removeFoodItemFromRestaurant(int restaurantId, int foodItemId) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == restaurantId) {
                restaurant.removeFoodItem(foodItemId);
                return;
            }
        }
    }
}
