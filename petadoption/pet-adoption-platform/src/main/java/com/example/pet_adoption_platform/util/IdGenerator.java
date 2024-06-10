package com.example.pet_adoption_platform.util;

import java.security.SecureRandom;
import java.util.Random;

//Utility class for generating random IDs.
 
public class IdGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int ID_LENGTH = 10;
    private static final Random RANDOM = new SecureRandom();

    //Generates a random ID.
     //@return A randomly generated ID.
     
    public static String generateRandomId() {
        StringBuilder sb = new StringBuilder(ID_LENGTH);
        for (int i = 0; i < ID_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
