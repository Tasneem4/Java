package com.tnsif.onlineshopping.entities;

import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<ProductQuantityPair> products;
    private String status;

    public Order(int orderId, Customer customer, List<ProductQuantityPair> products) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
        this.status = "Pending";
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public List<ProductQuantityPair> getProducts() { return products; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId)
          .append(", Customer: ").append(customer.getUsername())
          .append(", Status: ").append(status).append("\nProducts:\n");
        for (ProductQuantityPair pqp : products) {
            sb.append("  - ").append(pqp).append("\n");
        }
        return sb.toString();
    }
}
