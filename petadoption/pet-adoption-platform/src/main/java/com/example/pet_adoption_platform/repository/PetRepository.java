package com.example.pet_adoption_platform.repository;

import com.example.pet_adoption_platform.model.Pet;
import com.example.pet_adoption_platform.model.PetBreed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Pet entities.
 */
public interface PetRepository extends JpaRepository<Pet, Integer> {
    
    //Find pets by pet breed.
     
     //@param petBreed The pet breed to search for.
     //@return A list of pets belonging to the specified pet breed.
     
    List<Pet> findByPetBreed(PetBreed petBreed);
    
    //Custom query to find the maximum ID of pets.
     //@return The maximum ID of pets as an Optional<Integer>.
     
    @Query("SELECT MAX(p.id) FROM Pet p")
    Optional<Integer> findMaxId();
}
