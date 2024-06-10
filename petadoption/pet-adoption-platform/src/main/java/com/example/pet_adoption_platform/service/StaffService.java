package com.example.pet_adoption_platform.service;

import com.example.pet_adoption_platform.model.Staff;
import com.example.pet_adoption_platform.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing staff members.
 */
@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    //Authenticates a staff member.
     // @param username The username of the staff member.
    // @param password The password of the staff member.
     //@return The authenticated staff member, or null if authentication fails.
     
    public Staff authenticate(String username, String password) {
        return staffRepository.findByUsernameAndPassword(username, password);
    }

    //Retrieves all staff members.
     //@return A list of all staff members.
    
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    //Retrieves a staff member by their ID.
     //@param id The ID of the staff member.
     // @return The staff member with the specified ID, or null if not found.
     
    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    //Saves or updates a staff member.
     //@param staff The staff member to save or update.
     
    public void saveStaff(Staff staff) {
        staffRepository.save(staff);
    }

    //Deletes a staff member by their ID.
     //@param id The ID of the staff member to delete.
     
    public void deleteStaffById(Long id) {
        staffRepository.deleteById(id);
    }
}
