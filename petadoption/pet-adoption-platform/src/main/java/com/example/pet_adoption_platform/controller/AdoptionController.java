package com.example.pet_adoption_platform.controller;

import com.example.pet_adoption_platform.model.AdoptedPet;
import com.example.pet_adoption_platform.model.AdoptionForm;
import com.example.pet_adoption_platform.model.Customer;
import com.example.pet_adoption_platform.model.Pet;
import com.example.pet_adoption_platform.service.AdoptionService;
import com.example.pet_adoption_platform.service.CustomerService;
import com.example.pet_adoption_platform.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class AdoptionController {

    @Autowired
    private PetService petService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AdoptionService adoptionService;

    // Displays the adoption form for a specific pet.
    @GetMapping("/adopt-form/{petId}")
    public String showAdoptionForm(@PathVariable("petId") int petId, Model model) {
        Pet pet = petService.getPetById(petId);
        if (pet == null) {
            return "error/404"; // or any other error page
        }
        model.addAttribute("pet", pet);

        // Generate a random customer ID
        AdoptionForm adoptionForm = new AdoptionForm();
        adoptionForm.setCustomerId(UUID.randomUUID().toString().substring(0, 10));

        model.addAttribute("adoptionForm", adoptionForm);
        return "adopt-form";
    }

    // Submits the adoption form and saves the adoption details.
    @PostMapping("/submit-adoption")
    public String submitAdoptionForm(@ModelAttribute("adoptionForm") AdoptionForm adoptionForm, Model model) {
        Pet pet = petService.getPetById(adoptionForm.getPetId());

        // Create a new customer with the provided information
        Customer customer = new Customer();
        customer.setName(adoptionForm.getCustomerName());
        customer.setEmail(adoptionForm.getCustomerEmail());
        customer.setAddress(adoptionForm.getCustomerAddress());
        customer.setPhone(adoptionForm.getCustomerPhone());
        customer.setId(adoptionForm.getCustomerId());

        // Save the customer
        customerService.saveCustomer(customer);

        // Save the adoption details
        adoptionService.saveAdoption(customer, pet);

        // Generate a random invoice ID for this adoption
        int invoiceId = UUID.randomUUID().toString().substring(0, 10).hashCode();

        // Pass necessary data to invoice.html
        model.addAttribute("pet", pet);
        model.addAttribute("customer", customer);
        model.addAttribute("invoiceId", invoiceId);
        model.addAttribute("date", "January 1, 2024");

        // Redirect to invoice.html
        return "invoice";
    }

    // Displays adoption details for all customers.
    @GetMapping("/customer-adoption-details")
    public String getCustomerAdoptionDetails(Model model) {
        List<AdoptedPet> adoptions = adoptionService.getAllAdoptedPets();
        model.addAttribute("adoptions", adoptions);
        return "customer-adoption-details";
    }
}
