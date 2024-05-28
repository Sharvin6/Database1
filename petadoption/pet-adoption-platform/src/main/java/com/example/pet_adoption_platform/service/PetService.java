package com.example.pet_adoption_platform.service;

import com.example.pet_adoption_platform.model.Pet;
import com.example.pet_adoption_platform.model.PetBreed;
import com.example.pet_adoption_platform.model.PetType;
import com.example.pet_adoption_platform.repository.PetBreedRepository;
import com.example.pet_adoption_platform.repository.PetRepository;
import com.example.pet_adoption_platform.repository.PetTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PetService {

    @Autowired
    private PetTypeRepository petTypeRepository;

    @Autowired
    private PetBreedRepository petBreedRepository;

    @Autowired
    private PetRepository petRepository;

    public List<PetType> getAllPetTypes() {
        return petTypeRepository.findAll();
    }

    public List<PetBreed> getBreedsByType(PetType type) {
        return petBreedRepository.findByPetType(type);
    }

    public PetBreed getBreedById(int id) {
        return petBreedRepository.findById(id).orElse(null);
    }

    public List<Pet> getPetsByBreed(PetBreed breed) {
        return petRepository.findByPetBreed(breed);
    }
}
