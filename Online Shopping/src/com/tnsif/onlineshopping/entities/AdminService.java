package com.tnsif.onlineshopping.entities;

public interface AdminService {
    void addProduct(Product product);
    void removeProduct(int productId);
    void updateOrderStatus(int orderId, String status);
    void addAdmin(Admin admin);
    void viewAdmins();
}
