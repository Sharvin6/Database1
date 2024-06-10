package com.example.pet_adoption_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pet_adoption_platform.model.Customer;

/**
 * Repository interface for managing Customer entities.
 */
public interface CustomerRepository extends JpaRepository<Customer, String> {
    
    /**
     * Check if a customer with the given name exists.
     * 
     * @param name The name of the customer to check.
     * @return true if a customer with the given name exists, false otherwise.
     */
    boolean existsByName(String name);
}
