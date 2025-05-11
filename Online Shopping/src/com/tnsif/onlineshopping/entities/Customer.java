package com.tnsif.onlineshopping.entities;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String address;
    private ShoppingCart cart;
    private List<Order> orders;

    public Customer(int userId, String username, String email, String address) {
        super(userId, username, email);
        this.address = address;
        this.cart = new ShoppingCart();
        this.orders = new ArrayList<>();
    }

    public String getAddress() { return address; }
    public ShoppingCart getCart() { return cart; }
    public List<Order> getOrders() { return orders; }

    @Override
    public String toString() {
        return super.toString() + ", Address: " + address;
    }
}

