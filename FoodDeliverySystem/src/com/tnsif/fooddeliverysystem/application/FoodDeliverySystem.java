package com.tnsif.fooddeliverysystem.application;

import com.tnsif.fooddeliverysystem.entities.*;
import com.tnsif.fooddeliverysystem.services.*;

import java.util.*;

public class FoodDeliverySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FoodService foodService = new FoodService();
        CustomerService customerService = new CustomerService();

        System.out.println("=== Welcome to Food Delivery System ===");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. View All Restaurants");
            System.out.println("4. View All Food Items");
            System.out.println("5. Add Customer");
            System.out.println("6. Place Order");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Restaurant ID: ");
                    int rid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Restaurant Name: ");
                    String rname = sc.nextLine();
                    foodService.addRestaurant(new Restaurant(rid, rname));
                    System.out.println("Restaurant added.");
                    break;

                case 2:
                    System.out.print("Enter Restaurant ID: ");
                    int restId = sc.nextInt();
                    System.out.print("Enter Food ID: ");
                    int fid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Food Name: ");
                    String fname = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    foodService.addFoodItemToRestaurant(restId, new FoodItem(fid, fname, price));
                    System.out.println("Food item added.");
                    break;

                case 3:
                    for (Restaurant r : foodService.getRestaurants()) {
                        System.out.println(r);
                    }
                    break;

                case 4:
                    for (FoodItem item : foodService.getAllFoodItems()) {
                        System.out.println(item);
                    }
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Username: ");
                    String cname = sc.nextLine();
                    System.out.print("Contact No: ");
                    long contact = sc.nextLong();
                    Customer customer = new Customer(cid, cname, contact);
                    customerService.addCustomer(customer);
                    System.out.println("Customer added.");
                    break;

                case 6:
                    System.out.print("Enter Customer ID to place order: ");
                    int orderCustId = sc.nextInt();
                    Customer c = customerService.getCustomer(orderCustId);
                    if (c == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    Cart cart = c.getCart();

                    while (true) {
                        System.out.println("1. Add to Cart  2. View Cart  3. Confirm Order  4. Cancel");
                        int op = sc.nextInt();

                        if (op == 1) {
                            System.out.print("Enter Food ID: ");
                            int fId = sc.nextInt();
                            FoodItem itemToAdd = null;
                            for (FoodItem fi : foodService.getAllFoodItems()) {
                                if (fi.getId() == fId) {
                                    itemToAdd = fi;
                                    break;
                                }
                            }
                            if (itemToAdd != null) {
                                System.out.print("Enter Quantity: ");
                                int qty = sc.nextInt();
                                cart.addItem(itemToAdd, qty);
                                System.out.println("Added to cart.");
                            } else {
                                System.out.println("Food item not found.");
                            }

                        } else if (op == 2) {
                            System.out.println("Your Cart: " + cart);
                        } else if (op == 3) {
                            System.out.print("Enter Order ID: ");
                            int oid = sc.nextInt();
                            Order order = new Order(oid, c);
                            for (Map.Entry<FoodItem, Integer> e : cart.getItems().entrySet()) {
                                order.addItem(e.getKey(), e.getValue());
                            }
                            order.setStatus("Confirmed");
                            System.out.println("Order Placed:\n" + order);
                            cart.getItems().clear();
                            break;
                        } else {
                            break;
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
