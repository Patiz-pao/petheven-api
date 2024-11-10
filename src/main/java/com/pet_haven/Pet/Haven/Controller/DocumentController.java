package com.pet_haven.Pet.Haven.Controller;

import com.pet_haven.Pet.Haven.Repository.ProductRepo;
import com.pet_haven.Pet.Haven.Services.DocumentServices;
import com.pet_haven.Pet.Haven.Services.domain.productsReq;
import com.pet_haven.Pet.Haven.Util.GenericResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class DocumentController {

    private DocumentServices documentServices;
    private ProductRepo productRepo;

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot API!";
    }

    @PostMapping("/products")
    public GenericResponse saveProducts(@RequestBody productsReq productsReq) {

        GenericResponse response = documentServices.saveProducts(productsReq);
        log.info("save products success");

        return response;
    }

    @GetMapping("/products")
    public GenericResponse getProducts() {

        GenericResponse response = documentServices.getProducts();
        log.info("get products success");

        return response;
    }

}
