package com.example.pet_adoption_platform.service;

import com.example.pet_adoption_platform.model.Customer;
import com.example.pet_adoption_platform.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing customers.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //Retrieves all customers.
     // @return A list of all customers.
     
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    //Saves a customer.
     //@param customer The customer to save.
     
    public void saveCustomer(Customer customer) {
        // Logic to save customer information
        // For simplicity, let's assume it just prints a message
        System.out.println("Customer " + customer.getName() + " saved successfully.");
    }

    //Retrieves a customer by ID.
     // @param id The ID of the customer.
     // @return The customer with the specified ID, or null if not found.
     
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    //Deletes a customer by ID.
     //@param id The ID of the customer to delete.
     
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    //Checks if a customer exists by name.
     // @param name The name of the customer.
     //@return true if a customer with the given name exists, false otherwise.
     
    public boolean customerExistsByName(String name) {
        return customerRepository.existsByName(name);
    }
}
