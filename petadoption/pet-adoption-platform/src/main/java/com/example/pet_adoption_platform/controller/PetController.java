package com.example.pet_adoption_platform.controller;

import com.example.pet_adoption_platform.model.AdoptionForm;
import com.example.pet_adoption_platform.model.Pet;
import com.example.pet_adoption_platform.model.PetBreed;
import com.example.pet_adoption_platform.model.PetType;
import com.example.pet_adoption_platform.service.PetService;
import com.example.pet_adoption_platform.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

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

    @GetMapping("/adopt/{petId}")
    public String showAdoptionForm(@PathVariable int petId, Model model) {
        Pet pet = petService.getPetById(petId);
        if (pet == null) {
            return "error/404"; // Handle case where pet is not found
        }
        AdoptionForm adoptionForm = new AdoptionForm();
        adoptionForm.setCustomerId(IdGenerator.generateRandomId());
        model.addAttribute("pet", pet);
        model.addAttribute("adoptionForm", adoptionForm); // Pass the initialized AdoptionForm object
        return "adopt-form"; // Ensure this matches your actual HTML file name
    }

    @GetMapping("/staff/listofpets")
    public String listPets(Model model) {
        List<Pet> pets = petService.getAllPets();
        model.addAttribute("pets", pets);
        return "list"; // Ensure you have a list.html template in src/main/resources/templates
    }

    @GetMapping("/staff/createpet")
    public String showCreatePetForm(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("petTypes", petService.getAllPetTypes());
        model.addAttribute("petBreeds", petService.getAllBreeds());
        return "create-pet";
    }

    @PostMapping("/staff/createpet")
    public String createPet(@ModelAttribute("pet") Pet pet) {
        pet.setId(petService.getNextPetId());
        
        petService.savePet(pet);
        return "redirect:/staff/listofpets";
    }

    @GetMapping("/pet-details")
    public String petDetailsPage(Model model) {
        List<Pet> pets = petService.getAllPets();
        model.addAttribute("pets", pets);
        return "pet-details";
    }

    @GetMapping("/edit-pet")
    public String editPetPage(@RequestParam("id") int id, Model model) {
        Pet pet = petService.getPetById(id);
        model.addAttribute("pet", pet);
        // Assuming you also need to pass petTypes and petBreeds to the edit-pet.html page
        model.addAttribute("petTypes", petService.getAllPetTypes());
        model.addAttribute("petBreeds", petService.getAllBreeds());
        return "edit-pet";
    }

    @PostMapping("/update-pet")
    public String updatePet(@ModelAttribute("pet") Pet pet) {
        petService.savePet(pet);
        // Redirect to pet-details.html
        return "redirect:/pet-details";
    }

    // Mapping to display the delete pet page
    @GetMapping("/staff/delete-pet")
    public String showDeletePetPage(Model model) {
        List<Pet> pets = petService.getAllPets();
        model.addAttribute("pets", pets);
        return "delete-pet";
    }

    // Mapping to handle the deletion of pets
    @PostMapping("/staff/delete-pet")
    public String deletePet(@RequestParam("id") int id) {
        petService.deletePetById(id);
        return "redirect:/staff/delete-pet";
    }
    
}
