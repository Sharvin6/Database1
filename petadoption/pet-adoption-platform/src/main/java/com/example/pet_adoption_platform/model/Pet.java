package com.example.pet_adoption_platform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

// This annotation specifies that the class is an entity and is mapped to a database table.
@Entity
public class Pet {

    // Specifies the primary key of an entity and the strategy for generating unique identifiers.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Basic fields for the Pet entity.
    private String name;
    private int age;
    private String gender;
    private String color;
    private String description;
    private double fee; // Adoption fee for the pet
    private String image_url; // URL of the pet's image

    // Many-to-one relationship between Pet and PetType.
    // This specifies that many pets can belong to one pet type.
    @ManyToOne
    @JoinColumn(name = "pet_type_id") // Specifies the foreign key column in the pet table.
    private PetType petType;

    // Many-to-one relationship between Pet and PetBreed.
    // This specifies that many pets can belong to one breed.
    @ManyToOne
    @JoinColumn(name = "pet_breed_id") // Specifies the foreign key column in the pet table.
    private PetBreed petBreed;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetBreed getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(PetBreed petBreed) {
        this.petBreed = petBreed;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}

/*Explanation of Annotations:
@Entity: Indicates that this class is a JPA entity.
@Id: Specifies the primary key of an entity.
@GeneratedValue(strategy = GenerationType.IDENTITY): Specifies the primary key generation strategy. IDENTITY means that the database will automatically generate the primary key value.
@ManyToOne: Defines a many-to-one relationship between Pet and another entity.
@JoinColumn(name = "pet_type_id"): Specifies the foreign key column used for the relationship.


Fields:
id: Unique identifier for each pet.
name: Name of the pet.
age: Age of the pet.
gender: Gender of the pet.
color: Color of the pet.
description: Description of the pet.
fee: Adoption fee for the pet.
image_url: URL of the pet's image.
petType: Type of the pet (e.g., dog, cat).
petBreed: Breed of the pet.
This structure allows the Pet entity to be stored in a database with relationships to PetType and PetBreed entities, facilitating comprehensive pet management in the pet adoption platform. */
