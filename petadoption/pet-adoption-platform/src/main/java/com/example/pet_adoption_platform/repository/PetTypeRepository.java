package com.example.pet_adoption_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet_adoption_platform.model.PetType;

/**
 * Repository interface for managing PetType entities.
 */
public interface PetTypeRepository extends JpaRepository<PetType, Integer> {
}
