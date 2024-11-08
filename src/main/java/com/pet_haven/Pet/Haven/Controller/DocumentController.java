package com.pet_haven.Pet.Haven.Controller;

import com.pet_haven.Pet.Haven.Entity.ProductEntity;
import com.pet_haven.Pet.Haven.Repository.ProductRepo;
import com.pet_haven.Pet.Haven.Services.DocumentServices;
import com.pet_haven.Pet.Haven.Util.GenericResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pet_haven.Pet.Haven.Services.domain.productsReq;

import java.time.LocalDateTime;

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
    public GenericResponse saveProduct(@RequestBody productsReq productsReq) {

        GenericResponse response = documentServices.saveProduct(productsReq);

        return response;
    }

}
