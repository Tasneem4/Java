package com.tnsif.onlineshopping.entities;

public interface CustomerService {
    void addCustomer(Customer customer);
    void placeOrder(int orderId, Customer customer);
    void viewOrders(Customer customer);
}

