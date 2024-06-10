package com.example.pet_adoption_platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//This controller handles requests to the home page.

@Controller
public class HomeController {

    //Handles GET requests to the root URL ("/") and returns the name of the view to be rendered.
     
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
