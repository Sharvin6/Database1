package com.example.pet_adoption_platform.service;

import com.example.pet_adoption_platform.model.Customer;
import com.example.pet_adoption_platform.model.Pet;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {

    // Method to save adoption record
    public void saveAdoption(Customer customer, Pet pet) {
        // Logic to save the adoption record
        // For simplicity, let's assume it just prints a message
        System.out.println(customer.getName() + " adopts " + pet.getName());
    }
}
