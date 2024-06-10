package com.example.pet_adoption_platform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// This annotation specifies that the class is an entity and is mapped to a database table.
@Entity
public class Customer {

    // Specifies the primary key of an entity and the strategy for generating unique identifiers.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    // Basic fields for customer details.
    private String name;
    private String email;
    private String phone;
    private String address; // New field for address

    // Default constructor (no arguments) for JPA.
    public Customer() {
    }

    // Constructor with parameters to initialize the fields.
    public Customer(String id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getter and setter methods for each field to allow access and modification.

    // Returns the unique identifier of the customer.
    public String getId() {
        return id;
    }

    // Sets the unique identifier of the customer.
    public void setId(String id) {
        this.id = id;
    }

    // Returns the name of the customer.
    public String getName() {
        return name;
    }

    // Sets the name of the customer.
    public void setName(String name) {
        this.name = name;
    }

    // Returns the email of the customer.
    public String getEmail() {
        return email;
    }

    // Sets the email of the customer.
    public void setEmail(String email) {
        this.email = email;
    }

    // Returns the phone number of the customer.
    public String getPhone() {
        return phone;
    }

    // Sets the phone number of the customer.
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Returns the address of the customer.
    public String getAddress() {
        return address;
    }

    // Sets the address of the customer.
    public void setAddress(String address) {
        this.address = address;
    }

    // Overrides the toString method to provide a string representation of the Customer object.
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
    }
}
