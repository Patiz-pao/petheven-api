package com.pet_haven.Pet.Haven.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot API!";
    }

    @GetMapping("/testapi")
    public String test() {
        return "Hello PetHaven";
    }

}
