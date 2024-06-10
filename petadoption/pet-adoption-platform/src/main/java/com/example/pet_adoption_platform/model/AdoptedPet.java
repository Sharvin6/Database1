package com.example.pet_adoption_platform.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// This annotation specifies that the class is an entity and is mapped to a database table.
@Entity
public class AdoptedPet {

    // Specifies the primary key of an entity and the strategy for generating unique identifiers.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Many-to-one relationship with the Customer entity.
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Many-to-one relationship with the Pet entity.
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    // Basic fields for adopted pet details.
    private String petType;
    private String petBreed;
    private Date adoptionDate;
    private Double fee;

    // New fields for pet name and customer name
    private String petName;
    private String customerName;

    // Getters and setters

    // Returns the unique identifier of the adopted pet.
    public Integer getId() {
        return id;
    }

    // Sets the unique identifier of the adopted pet.
    public void setId(Integer id) {
        this.id = id;
    }

    // Returns the customer who adopted the pet.
    public Customer getCustomer() {
        return customer;
    }

    // Sets the customer who adopted the pet and updates the customerName field.
    public void setCustomer(Customer customer) {
        this.customer = customer;
        // Set the customerName whenever the customer is set
        if (customer != null) {
            this.customerName = customer.getName();
        }
    }

    // Returns the adopted pet.
    public Pet getPet() {
        return pet;
    }

    // Sets the adopted pet and updates the petName field.
    public void setPet(Pet pet) {
        this.pet = pet;
        // Set the petName whenever the pet is set
        if (pet != null) {
            this.petName = pet.getName();
        }
    }

    // Returns the type of the adopted pet.
    public String getPetType() {
        return petType;
    }

    // Sets the type of the adopted pet.
    public void setPetType(String petType) {
        this.petType = petType;
    }

    // Returns the breed of the adopted pet.
    public String getPetBreed() {
        return petBreed;
    }

    // Sets the breed of the adopted pet.
    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    // Returns the adoption date.
    public Date getAdoptionDate() {
        return adoptionDate;
    }

    // Sets the adoption date.
    public void setAdoptionDate(Date adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    // Returns the adoption fee.
    public Double getFee() {
        return fee;
    }

    // Sets the adoption fee.
    public void setFee(Double fee) {
        this.fee = fee;
    }

    // Returns the name of the adopted pet.
    public String getPetName() {
        return petName;
    }

    // Sets the name of the adopted pet.
    public void setPetName(String petName) {
        this.petName = petName;
    }

    // Returns the name of the customer who adopted the pet.
    public String getCustomerName() {
        return customerName;
    }

    // Sets the name of the customer who adopted the pet.
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

/*
 * Explanation of Annotations and Code:
@Entity: Indicates that this class is a JPA entity, meaning it will be mapped to a database table.
@Id: Specifies the primary key of the entity.
@GeneratedValue(strategy = GenerationType.IDENTITY): Specifies the primary key generation strategy. IDENTITY means that the database will automatically generate the primary key value.
@ManyToOne: Defines a many-to-one relationship between entities.
@JoinColumn(name = "customer_id"): Specifies the foreign key column for the customer in the AdoptedPet table.
@JoinColumn(name = "pet_id"): Specifies the foreign key column for the pet in the AdoptedPet table.
 */