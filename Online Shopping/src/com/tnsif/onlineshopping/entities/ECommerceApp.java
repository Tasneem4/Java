package com.tnsif.onlineshopping.entities;

import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ECommerceServiceImpl service = new ECommerceServiceImpl();

        while (true) {
            System.out.println("\n1. Admin Menu\n2. Customer Menu\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                while (true) {
                    System.out.println("\n--- Admin Menu ---");
                    System.out.println("1. Add Product\n2. Remove Product\n3. View Products\n4. Create Admin");
                    System.out.println("5. View Admins\n6. Update Order Status\n7. View Orders\n8. Return");
                    int adminChoice = sc.nextInt();

                    switch (adminChoice) {
                        case 1:
                            System.out.print("Enter Product ID: ");
                            int pid = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Name: ");
                            String pname = sc.nextLine();
                            System.out.print("Enter Price: ");
                            double price = sc.nextDouble();
                            System.out.print("Enter Stock: ");
                            int stock = sc.nextInt();
                            service.addProduct(new Product(pid, pname, price, stock));
                            break;
                        case 2:
                            System.out.print("Enter Product ID to remove: ");
                            service.removeProduct(sc.nextInt());
                            break;
                        case 3:
                            for (Product p : service.getAllProducts()) {
                                System.out.println(p);
                            }
                            break;
                        case 4:
                            System.out.print("Enter Admin ID: ");
                            int aid = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Username: ");
                            String aname = sc.nextLine();
                            System.out.print("Email: ");
                            String aemail = sc.nextLine();
                            service.addAdmin(new Admin(aid, aname, aemail));
                            break;
                        case 5:
                            service.viewAdmins();
                            break;
                        case 6:
                            System.out.print("Enter Order ID: ");
                            int oid = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Status (Completed/Delivered/Cancelled): ");
                            String status = sc.nextLine();
                            service.updateOrderStatus(oid, status);
                            break;
                        case 7:
                            for (Order o : service.getAllOrders()) {
                                System.out.println(o);
                            }
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                    if (adminChoice == 8) break;
                }

            } else if (choice == 2) {
                Customer customer = null;
                while (true) {
                    System.out.println("\n--- Customer Menu ---");
                    System.out.println("1. Create Customer\n2. View Products\n3. Add to Cart\n4. View Cart\n5. Place Order\n6. View Orders\n7. Return");
                    int custChoice = sc.nextInt();

                    switch (custChoice) {
                        case 1:
                            System.out.print("User ID: ");
                            int cid = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Username: ");
                            String cname = sc.nextLine();
                            System.out.print("Email: ");
                            String cemail = sc.nextLine();
                            System.out.print("Address: ");
                            String addr = sc.nextLine();
                            customer = new Customer(cid, cname, cemail, addr);
                            service.addCustomer(customer);
                            break;

                        case 2:
                            for (Product p : service.getAllProducts()) {
                                System.out.println(p);
                            }
                            break;

                        case 3:
                            if (customer == null) {
                                System.out.println("Create customer first.");
                                break;
                            }
                            System.out.print("Enter Product ID: ");
                            int pid = sc.nextInt();
                            System.out.print("Enter Quantity: ");
                            int qty = sc.nextInt();
                            Product prod = service.findProductById(pid);
                            if (prod != null) {
                                customer.getCart().addItem(prod, qty);
                                System.out.println("Added to cart.");
                            } else {
                                System.out.println("Product not found.");
                            }
                            break;

                        case 4:
                            if (customer != null)
                                System.out.println(customer.getCart());
                            break;

                        case 5:
                            if (customer != null) {
                                System.out.print("Enter Order ID: ");
                                int oid = sc.nextInt();
                                service.placeOrder(oid, customer);
                            }
                            break;

                        case 6:
                            if (customer != null) {
                                service.viewOrders(customer);
                            }
                            break;

                        case 7:
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }

                    if (custChoice == 7) break;
                }

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
