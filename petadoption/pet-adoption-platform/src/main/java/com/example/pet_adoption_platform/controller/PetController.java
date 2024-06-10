package com.example.pet_adoption_platform.controller;

import com.example.pet_adoption_platform.model.AdoptionForm;
import com.example.pet_adoption_platform.model.Pet;
import com.example.pet_adoption_platform.model.PetBreed;
import com.example.pet_adoption_platform.model.PetType;
import com.example.pet_adoption_platform.service.PetService;
import com.example.pet_adoption_platform.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class PetController {

    private final PetService petService;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    // Displays the contact page.
    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }

    // Retrieves and displays the list of pets.
    @GetMapping("/pets")
    public String getPets(Model model) {
        // Retrieve all pet types and their corresponding breeds from the service layer.
        List<PetType> petTypes = petService.getAllPetTypes();
        
        // Iterate through each pet type to populate its list of breeds.
        for (PetType type : petTypes) {
            type.setBreeds(petService.getBreedsByType(type));
        }
        
        // Add the list of pet types with breeds to the model for rendering on the pets page.
        model.addAttribute("petTypes", petTypes);
        
        // Return the name of the Thymeleaf template for rendering.
        return "pets";
    }

    // Retrieves and displays details of a specific breed.
    @GetMapping("/breed-details/{id}")
    public String getBreedDetails(@PathVariable("id") int id, Model model) {
        // Retrieve the breed details by its ID from the service layer.
        PetBreed breed = petService.getBreedById(id);
        
        // Retrieve all pets belonging to the specified breed.
        List<Pet> pets = petService.getPetsByBreed(breed);
        
        // Add the breed and its pets to the model for rendering on the breed-details page.
        model.addAttribute("breed", breed);
        model.addAttribute("pets", pets);
        
        // Return the name of the Thymeleaf template for rendering.
        return "breed-details";
    }

    // Displays the adoption form for a specific pet.
    @GetMapping("/adopt/{petId}")
    public String showAdoptionForm(@PathVariable int petId, Model model) {
        // Retrieve the pet details by its ID from the service layer.
        Pet pet = petService.getPetById(petId);
        
        // If the pet is not found, return an error page.
        if (pet == null) {
            return "error/404";
        }
        
        // Create a new AdoptionForm instance with a generated customer ID.
        AdoptionForm adoptionForm = new AdoptionForm();
        adoptionForm.setCustomerId(IdGenerator.generateRandomId());
        
        // Add the pet and adoption form to the model for rendering on the adopt-form page.
        model.addAttribute("pet", pet);
        model.addAttribute("adoptionForm", adoptionForm);
        
        // Return the name of the Thymeleaf template for rendering.
        return "adopt-form";
    }

    // Displays the list of pets for staff.
    @GetMapping("/staff/listofpets")
    public String listPets(Model model) {
        // Retrieve all pets from the service layer.
        List<Pet> pets = petService.getAllPets();
        
        // Add the list of pets to the model for rendering on the list page.
        model.addAttribute("pets", pets);
        
        // Return the name of the Thymeleaf template for rendering.
        return "list";
    }

    // Displays the form to create a new pet.
    @GetMapping("/staff/createpet")
    public String createPetForm(Model model) {
        // Add an empty Pet object and lists of pet types and breeds to the model.
        model.addAttribute("pet", new Pet());
        model.addAttribute("petTypes", petService.getAllPetTypes());
        model.addAttribute("petBreeds", petService.getAllBreeds());
        
        // Return the name of the Thymeleaf template for rendering.
        return "create-pet";
    }

    // Processes the submission of the new pet creation form.
    @PostMapping("/staff/createpet")
    public String createPet(@RequestParam("name") String name,
                            @RequestParam("age") int age,
                            @RequestParam("gender") String gender,
                            @RequestParam("color") String color,
                            @RequestParam("description") String description,
                            @RequestParam("fee") double fee,
                            @RequestParam("petType") int petTypeId,
                            @RequestParam("petBreed") int petBreedId,
                            @RequestParam("image") MultipartFile image) {

        // Retrieve the pet type and breed objects based on the provided IDs.
        PetType petType = petService.getPetTypeById(petTypeId);
        PetBreed petBreed = petService.getBreedById(petBreedId);

        // Create a new Pet object with the provided details.
        Pet pet = new Pet();
        pet.setName(name);
        pet.setAge(age);
        pet.setGender(gender);
        pet.setColor(color);
        pet.setDescription(description);
        pet.setFee(fee);
        pet.setPetType(petType);
        pet.setPetBreed(petBreed);

        // Process the uploaded image, if available.
        if (!image.isEmpty()) {
            try {
                // Ensure the upload directory exists; create it if not.
                Path uploadDir = Paths.get(uploadPath);
                if (!Files.exists(uploadDir)) {
                    Files.createDirectories(uploadDir);
                }
                
                // Save the uploaded image file to the upload directory.
                byte[] bytes = image.getBytes();
                Path path = uploadDir.resolve(image.getOriginalFilename());
                Files.write(path, bytes);
                
                // Set the image URL for the pet.
                pet.setImage_url("/images/" + image.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Save the newly created pet using the PetService.
        petService.savePet(pet);
        
        // Redirect to the list of pets page for staff.
        return "redirect:/staff/listofpets";
    }

    // Displays the pet details page.
    @GetMapping("/pet-details")
    public String petDetailsPage(Model model) {
        // Retrieve all pets from the service layer.
        List<Pet> pets = petService.getAllPets();
        
        // Add the list of pets to the model for rendering on the pet-details page.
        model.addAttribute("pets", pets);
        
        // Return the name of the Thymeleaf template for rendering.
        return "pet-details";
    }

    // Displays the edit pet page with pre-filled form fields.
    @GetMapping("/edit-pet")
    public String editPetPage(@RequestParam("id") int id, Model model) {
        // Retrieve the pet details by its ID from the service layer.
        Pet pet = petService.getPetById(id);
        
        // Add the pet object and lists of pet types and breeds to the model.
        model.addAttribute("pet", pet);
        model.addAttribute("petTypes", petService.getAllPetTypes());
        model.addAttribute("petBreeds", petService.getAllBreeds());
        
        // Return the name of the Thymeleaf template for rendering.
        return "edit-pet";
    }

    // Processes the submission of the updated pet details form.
    @PostMapping("/update-pet")
    public String updatePet(@ModelAttribute Pet pet, @RequestParam("image") MultipartFile image) {
        // Process the uploaded image file, if provided.
        if (!image.isEmpty()) {
            try {
                // Clean the filename and prepare the upload path.
                String filename = StringUtils.cleanPath(image.getOriginalFilename());
                Path uploadPath = Paths.get("src/main/resources/static/images");

                // Ensure the upload directory exists; create it if not.
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                // Resolve the file path and copy the image file.
                Path filePath = uploadPath.resolve(filename);
                Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // Set the image URL for the pet.
                pet.setImage_url("/images/" + filename);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle error
            }
        }

        // Save the updated pet details using the PetService.
        petService.savePet(pet);
        
        // Redirect to the pet details page.
        return "redirect:/pet-details";
    }

    // Displays the page for staff to delete a pet.
    @GetMapping("/staff/delete-pet")
    public String showDeletePetPage(Model model) {
        // Retrieve all pets from the service layer.
        List<Pet> pets = petService.getAllPets();
        
        // Add the list of pets to the model for rendering on the delete-pet page.
        model.addAttribute("pets", pets);
        
        // Return the name of the Thymeleaf template for rendering.
        return "delete-pet";
    }

    // Processes the deletion of a pet by its ID.
    @PostMapping("/staff/delete-pet")
    public String deletePet(@RequestParam("id") int id) {
        // Delete the pet with the specified ID using the PetService.
        petService.deletePetById(id);
        
        // Redirect to the delete-pet page.
        return "redirect:/staff/delete-pet";
    }
}
