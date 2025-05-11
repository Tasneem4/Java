package com.tnsif.fooddeliverysystem.entities;

//Base class for Users


public class User {
 private int userId;
 private String username;
 private long contactNo;

 // Constructor
 public User(int userId, String username, long contactNo) {
     this.userId = userId;
     this.username = username;
     this.contactNo = contactNo;
 }

 // Getters
 public int getUserId() {
     return userId;
 }

 public String getUsername() {
     return username;
 }

 public long getContactNo() {
     return contactNo;
 }

 // toString method
 @Override
 public String toString() {
     return "User ID: " + userId + ", Username: " + username + ", Contact No: " + contactNo;
 }
}

