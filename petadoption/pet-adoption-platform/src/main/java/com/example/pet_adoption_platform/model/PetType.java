package com.example.pet_adoption_platform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

// This annotation specifies that the class is an entity and is mapped to a database table.
@Entity
public class PetType {

    // Specifies the primary key of an entity and the strategy for generating unique identifiers.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Basic field for the type of pet (e.g., Dog, Cat).
    private String type;

    // One-to-many relationship between PetType and PetBreed.
    // This specifies that one pet type can have many pet breeds.
    @OneToMany(mappedBy = "petType")
    private List<PetBreed> breeds;

    // One-to-many relationship between PetType and Pet.
    // This specifies that one pet type can have many pets.
    @OneToMany(mappedBy = "petType")
    private List<Pet> pets;

    // Getter and setter methods for each field to allow access and modification.

    // Returns the unique identifier of the pet type.
    public int getId() {
        return id;
    }

    // Sets the unique identifier of the pet type.
    public void setId(int id) {
        this.id = id;
    }

    // Returns the type of pet (e.g., Dog, Cat).
    public String getType() {
        return type;
    }

    // Sets the type of pet.
    public void setType(String type) {
        this.type = type;
    }

    // Returns the list of pet breeds associated with this pet type.
    public List<PetBreed> getBreeds() {
        return breeds;
    }

    // Sets the list of pet breeds associated with this pet type.
    public void setBreeds(List<PetBreed> breeds) {
        this.breeds = breeds;
    }

    // Returns the list of pets associated with this pet type.
    public List<Pet> getPets() {
        return pets;
    }

    // Sets the list of pets associated with this pet type.
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}

/* 
 * Explanation of Annotations:
@Entity: Indicates that this class is a JPA entity.
@Id: Specifies the primary key of an entity.
@GeneratedValue(strategy = GenerationType.IDENTITY): Specifies the primary key generation strategy. IDENTITY means that the database will automatically generate the primary key value.
@OneToMany(mappedBy = "petType"): Defines a one-to-many relationship between PetType and PetBreed, and between PetType and Pet. The mappedBy attribute indicates that the PetBreed and Pet entities contain the foreign key (petType).

Fields:
id: Unique identifier for each pet type.
type: Type of pet (e.g., Dog, Cat).
breeds: List of pet breeds associated with this pet type.
pets: List of pets associated with this pet type.
This structure allows the PetType entity to be stored in a database with relationships to PetBreed and Pet entities, facilitating comprehensive management of pet types within the pet adoption platform.
*/