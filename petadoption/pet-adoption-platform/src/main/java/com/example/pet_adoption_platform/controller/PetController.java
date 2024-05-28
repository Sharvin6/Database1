package com.example.pet_adoption_platform.controller;

import com.example.pet_adoption_platform.model.Pet;
import com.example.pet_adoption_platform.model.PetBreed;
import com.example.pet_adoption_platform.model.PetType;
import com.example.pet_adoption_platform.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    public String getPets(Model model) {
        List<PetType> petTypes = petService.getAllPetTypes();
        for (PetType type : petTypes) {
            type.setBreeds(petService.getBreedsByType(type));
        }
        model.addAttribute("petTypes", petTypes);
        return "pets";
    }

    @GetMapping("/breed-details/{id}")
    public String getBreedDetails(@PathVariable("id") int id, Model model) {
        PetBreed breed = petService.getBreedById(id);
        if (breed == null) {
            return "error/404"; // or any other error page
        }
        List<Pet> pets = petService.getPetsByBreed(breed);
        model.addAttribute("breed", breed);
        model.addAttribute("pets", pets);
        return "breed-details";
    }
}
