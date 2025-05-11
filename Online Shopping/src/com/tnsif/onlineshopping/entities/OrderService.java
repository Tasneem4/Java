package com.tnsif.onlineshopping.entities;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    Order getOrderById(int id);
    List<Order> getAllOrders();
}
