package com.example.pet_adoption_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet_adoption_platform.model.Staff;

/**
 * Repository interface for managing Staff entities.
 */
public interface StaffRepository extends JpaRepository<Staff, Long> {

    //Retrieves a staff member by their username and password.
     // @param username The username of the staff member.
     //@param password The password of the staff member.
     //@return The staff member with the given username and password, if found.
     
    Staff findByUsernameAndPassword(String username, String password);
}
