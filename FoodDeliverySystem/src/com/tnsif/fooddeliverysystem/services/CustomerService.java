package com.tnsif.fooddeliverysystem.services;



import java.util.ArrayList;
import java.util.List;
import com.tnsif.fooddeliverysystem.entities.Customer;

public class CustomerService {

    private List<Customer> customerList = new ArrayList<>();

    // Add a new customer
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    // Retrieve customer by userId
    public Customer getCustomer(int userId) {
        return customerList.stream()
                           .filter(customer -> customer.getUserId() == userId)
                           .findFirst()
                           .orElse(null);
    }

    // Get all customers
    public List<Customer> getCustomers() {
        return customerList;
    }
}

