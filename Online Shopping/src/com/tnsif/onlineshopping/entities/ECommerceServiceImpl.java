package com.tnsif.onlineshopping.entities;

import java.util.*;

public class ECommerceServiceImpl implements AdminService, CustomerService, ProductService, OrderService {

    private Map<Integer, Product> productMap = new HashMap<>();
    private Map<Integer, Order> orderMap = new HashMap<>();
    private Map<Integer, Customer> customerMap = new HashMap<>();
    private Map<Integer, Admin> adminMap = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
        System.out.println("Product added successfully!");
    }

    @Override
    public void removeProduct(int productId) {
        if (productMap.remove(productId) != null) {
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    @Override
    public void updateOrderStatus(int orderId, String status) {
        Order order = orderMap.get(orderId);
        if (order != null) {
            order.setStatus(status);
            System.out.println("Order status updated.");
        } else {
            System.out.println("Order not found.");
        }
    }

    @Override
    public void addAdmin(Admin admin) {
        adminMap.put(admin.getUserId(), admin);
        System.out.println("Admin added.");
    }

    @Override
    public void viewAdmins() {
        for (Admin admin : adminMap.values()) {
            System.out.println(admin);
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMap.put(customer.getUserId(), customer);
        System.out.println("Customer added.");
    }

    @Override
    public void placeOrder(int orderId, Customer customer) {
        List<ProductQuantityPair> products = new ArrayList<>();
        Map<Product, Integer> cartItems = customer.getCart().getItems();

        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            if (product.getStockQuantity() >= qty) {
                product.setStockQuantity(product.getStockQuantity() - qty);
                products.add(new ProductQuantityPair(product, qty));
            } else {
                System.out.println("Not enough stock for " + product.getName());
                return;
            }
        }

        Order order = new Order(orderId, customer, products);
        orderMap.put(orderId, order);
        customer.getOrders().add(order);
        customer.getCart().clearCart();
        System.out.println("Order placed successfully!");
    }

    @Override
    public void viewOrders(Customer customer) {
        for (Order order : customer.getOrders()) {
            System.out.println(order);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findProductById(int id) {
        return productMap.get(id);
    }

    @Override
    public void addOrder(Order order) {
        orderMap.put(order.getOrderId(), order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderMap.get(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderMap.values());
    }
}

