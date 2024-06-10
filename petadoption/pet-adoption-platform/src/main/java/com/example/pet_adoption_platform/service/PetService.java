package com.example.pet_adoption_platform.service;

import com.example.pet_adoption_platform.model.Pet;
import com.example.pet_adoption_platform.model.PetBreed;
import com.example.pet_adoption_platform.model.PetType;
import com.example.pet_adoption_platform.repository.PetBreedRepository;
import com.example.pet_adoption_platform.repository.PetRepository;
import com.example.pet_adoption_platform.repository.PetTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing pets.
 */
@Service
public class PetService {

    private final PetTypeRepository petTypeRepository;
    private final PetBreedRepository petBreedRepository;
    private final PetRepository petRepository;

    //Constructs a new PetService with the specified repositories.
     //@param petTypeRepository  Repository for pet types.
     //@param petBreedRepository Repository for pet breeds.
     //@param petRepository      Repository for pets.
    public PetService(PetTypeRepository petTypeRepository, PetBreedRepository petBreedRepository, PetRepository petRepository) {
        this.petTypeRepository = petTypeRepository;
        this.petBreedRepository = petBreedRepository;
        this.petRepository = petRepository;
    }

    // Retrieves all pet types.
     //@return A list of pet types.
    
    public List<PetType> getAllPetTypes() {
        return petTypeRepository.findAll();
    }

    //Retrieves breeds by pet type.
     // @param type The pet type.
     //@return A list of breeds for the given pet type.
     
    public List<PetBreed> getBreedsByType(PetType type) {
        return petBreedRepository.findByPetType(type);
    }

    //Retrieves a pet breed by ID.
     // @param id The ID of the pet breed.
     // @return The pet breed with the specified ID, or null if not found.
     
    public PetBreed getBreedById(int id) {
        return petBreedRepository.findById(id).orElse(null);
    }

    //Retrieves a pet type by ID.
     //@param id The ID of the pet type.
     //@return The pet type with the specified ID, or null if not found.
    
    public PetType getPetTypeById(int id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    //Retrieves pets by breed.
     //@param breed The pet breed.
     //@return A list of pets with the given breed.
    
    public List<Pet> getPetsByBreed(PetBreed breed) {
        return petRepository.findByPetBreed(breed);
    }

    // Retrieves a pet by ID.
     //@param id The ID of the pet.
     //@return The pet with the specified ID, or null if not found.
     
    public Pet getPetById(int id) {
        return petRepository.findById(id).orElse(null);
    }

    // Retrieves all pets.
     //@return A list of all pets.
     
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    //Saves a pet.
     //@param pet The pet to save.
     
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    //Retrieves all pet breeds.
     //@return A list of all pet breeds.
     
    public List<PetBreed> getAllBreeds() {
        return petBreedRepository.findAll();
    }

    //Retrieves the next available pet ID.
     //@return The next available pet ID.
     
    public int getNextPetId() {
        return petRepository.findMaxId().orElse(0) + 1;
    }

    //Deletes a pet by ID.
     //@param id The ID of the pet to delete.
     
    public void deletePetById(int id) {
        petRepository.deleteById(id);
    }
}
