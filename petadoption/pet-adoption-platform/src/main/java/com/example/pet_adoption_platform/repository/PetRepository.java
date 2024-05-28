package com.example.pet_adoption_platform.repository;

import com.example.pet_adoption_platform.model.Pet;
import com.example.pet_adoption_platform.model.PetBreed;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findByPetBreed(PetBreed petBreed);
}

