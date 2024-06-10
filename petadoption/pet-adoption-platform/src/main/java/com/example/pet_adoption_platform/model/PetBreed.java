package com.example.pet_adoption_platform.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

// This annotation specifies that the class is an entity and is mapped to a database table.
@Entity
public class PetBreed {

    // Specifies the primary key of an entity and the strategy for generating unique identifiers.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Basic field for the name of the pet breed.
    private String name;

    // Many-to-one relationship between PetBreed and PetType.
    // This specifies that many pet breeds can belong to one pet type.
    @ManyToOne
    @JoinColumn(name = "pet_type_id") // Specifies the foreign key column in the pet_breed table.
    private PetType petType;

    // One-to-many relationship between PetBreed and Pet.
    // This specifies that one pet breed can have many pets.
    @OneToMany(mappedBy = "petBreed")
    private List<Pet> pets;

    // Getter and setter methods for each field to allow access and modification.
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}

/*
Explanation of Annotations:
@Entity: Indicates that this class is a JPA entity.
@Id: Specifies the primary key of an entity.
@GeneratedValue(strategy = GenerationType.IDENTITY): Specifies the primary key generation strategy. IDENTITY means that the database will automatically generate the primary key value.
@ManyToOne: Defines a many-to-one relationship between PetBreed and PetType.
@JoinColumn(name = "pet_type_id"): Specifies the foreign key column used for the relationship with PetType.
@OneToMany(mappedBy = "petBreed"): Defines a one-to-many relationship between PetBreed and Pet. The mappedBy attribute indicates that the Pet entity contains the foreign key (petBreed).


Fields:
id: Unique identifier for each pet breed.
name: Name of the pet breed.
petType: Type of the pet to which the breed belongs.
pets: List of pets that belong to this breed.
This structure allows the PetBreed entity to be stored in a database with relationships to PetType and Pet entities, facilitating comprehensive management of pet breeds within the pet adoption platform.
 */