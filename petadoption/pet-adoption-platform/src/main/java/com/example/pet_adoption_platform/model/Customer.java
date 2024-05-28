package com.example.pet_adoption_platform.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String preferences;

    public Customer(){
    }

    public Customer(Long id, String name, String email, String preferences) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.preferences = preferences;
    }

        // Getters and Setters
        
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPreferences() {
        return preferences;
    }
    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", preferences=" + preferences + "]";
    }



    
}

