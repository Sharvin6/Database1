package com.example.pet_adoption_platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet_adoption_platform.model.PetBreed;
import com.example.pet_adoption_platform.model.PetType;

/**
 * Repository interface for managing PetBreed entities.
 */
public interface PetBreedRepository extends JpaRepository<PetBreed, Integer> {
    
    //Find pet breeds by pet type.
     
     /*@param petType The pet type to search for.
      @return A list of pet breeds belonging to the specified pet type.
     */
    List<PetBreed> findByPetType(PetType petType);
}
