package com.example.pet_adoption_platform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// This annotation specifies that the class is an entity and is mapped to a database table.
@Entity
public class Staff {

    // Specifies the primary key of an entity and the strategy for generating unique identifiers.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Basic fields for staff details.
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;

    // Getter and setter methods for each field to allow access and modification.

    // Returns the unique identifier of the staff.
    public int getId() {
        return id;
    }

    // Sets the unique identifier of the staff.
    public void setId(int id) {
        this.id = id;
    }

    // Returns the username of the staff.
    public String getUsername() {
        return username;
    }

    // Sets the username of the staff.
    public void setUsername(String username) {
        this.username = username;
    }

    // Returns the password of the staff.
    public String getPassword() {
        return password;
    }

    // Sets the password of the staff.
    public void setPassword(String password) {
        this.password = password;
    }

    // Returns the name of the staff.
    public String getName() {
        return name;
    }

    // Sets the name of the staff.
    public void setName(String name) {
        this.name = name;
    }

    // Returns the email of the staff.
    public String getEmail() {
        return email;
    }

    // Sets the email of the staff.
    public void setEmail(String email) {
        this.email = email;
    }

    // Returns the phone number of the staff.
    public String getPhone() {
        return phone;
    }

    // Sets the phone number of the staff.
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Constructor with parameters to initialize the fields.
    public Staff(String username, String password, String name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Default constructor (no arguments) for JPA.
    public Staff() {
    }
}
