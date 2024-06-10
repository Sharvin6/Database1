package com.example.pet_adoption_platform.model;

/**
 * This class represents the form used for adopting a pet.
 * It includes information about the customer and the pet to be adopted.
 */
public class AdoptionForm {

    // Customer's name
    private String customerName;

    // Customer's email
    private String customerEmail;

    // Customer's address
    private String customerAddress;

    // Customer's phone number
    private String customerPhone;

    // ID of the pet to be adopted
    private int petId;

    // ID of the customer
    private String customerId; // Add this field

    // Getters and Setters

    // Gets the customer's name.
     
    public String getCustomerName() {
        return customerName;
    }

    //Sets the customer's name.

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Gets the customer's email.    
    public String getCustomerEmail() {
        return customerEmail;
    }

    // Sets the customer's email.
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    // Gets the customer's address.
    public String getCustomerAddress() {
        return customerAddress;
    }

    //Sets the customer's address.
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    //Gets the customer's phone number.
    public String getCustomerPhone() {
        return customerPhone;
    }

    //Sets the customer's phone number.
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    //Gets the ID of the pet to be adopted.
    public int getPetId() {
        return petId;
    }

    // Sets the ID of the pet to be adopted.
    public void setPetId(int petId) {
        this.petId = petId;
    }

    //Gets the ID of the customer.
    public String getCustomerId() {
        return customerId;
    }

    //Sets the ID of the customer.
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
