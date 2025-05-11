package com.tnsif.onlineshopping.entities;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addItem(Product product, int quantity) {
        int existingQty = items.getOrDefault(product, 0);
        items.put(product, existingQty + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            double cost = p.getPrice() * qty;
            sb.append(p.getName()).append(" x ").append(qty).append(" = ₹").append(cost).append("\n");
            total += cost;
        }
        sb.append("Total: ₹").append(total);
        return sb.toString();
    }
}
