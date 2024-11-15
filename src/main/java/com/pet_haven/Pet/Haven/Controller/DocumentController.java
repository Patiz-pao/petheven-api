package com.pet_haven.Pet.Haven.Controller;

import com.pet_haven.Pet.Haven.Entity.CategoryEntity;
import com.pet_haven.Pet.Haven.Entity.ProductEntity;
import com.pet_haven.Pet.Haven.Repository.ProductRepo;
import com.pet_haven.Pet.Haven.Services.DocumentServices;
import com.pet_haven.Pet.Haven.Services.domain.CategoryReq;
import com.pet_haven.Pet.Haven.Services.domain.ProductsReq;
import com.pet_haven.Pet.Haven.Util.GenericResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public GenericResponse<ProductEntity> saveProducts(@RequestBody ProductsReq productsReq) {

        GenericResponse<ProductEntity> response = documentServices.saveProducts(productsReq);
        log.info("save products success");

        return response;
    }

    @DeleteMapping("/products/{rowid}")
    public GenericResponse<String> deleteProduct(@PathVariable String rowid) {
        GenericResponse<String> response = documentServices.deleteProduct(rowid);
        log.info("delete product success");

        return response;
    }

    @GetMapping("/products")
    public GenericResponse<List<ProductEntity>> getProducts() {

        GenericResponse<List<ProductEntity>> response = documentServices.getProducts();
        log.info("get products success");

        return response;
    }

    @GetMapping("/products/all")
    public GenericResponse<List<ProductEntity>> getAllProducts() {

        GenericResponse<List<ProductEntity>> response = documentServices.getAllProducts();
        log.info("get all products success");

        return response;
    }

    @GetMapping("/products/{rowId}")
    public GenericResponse<ProductEntity> getProductsById(@PathVariable String rowId) {

        GenericResponse<ProductEntity> response = documentServices.getProductsById(rowId);
        log.info("Get Product by rowId: {}", rowId);

        return response;
    }

    @PutMapping("/products/{rowId}")
    public GenericResponse<ProductEntity> updateProduct(@PathVariable String rowId, @RequestBody ProductsReq productsReq) {
        GenericResponse<ProductEntity> response = documentServices.updateProduct(rowId, productsReq);
        log.info("Product with rowId: {} updated successfully", rowId);
        return response;
    }

    @PutMapping("/status/{rowId}/{status}")
    public GenericResponse<ProductEntity> updateStatus(@PathVariable String rowId,@PathVariable String status, @RequestBody ProductsReq productsReq) {
        GenericResponse<ProductEntity> response = documentServices.updateStatus(rowId, status, productsReq);
        log.info("Product with rowId: {} updated successfully", rowId);
        return response;
    }

    @PostMapping("/category")
    public GenericResponse<CategoryEntity> saveCategory(@RequestBody CategoryReq categoryReq) {

        GenericResponse<CategoryEntity> response = documentServices.saveCategory(categoryReq);
        log.info("save Category success");

        return response;
    }

    @GetMapping("/category")
    public GenericResponse<List<CategoryEntity>> getCategory() {

        GenericResponse<List<CategoryEntity>> response = documentServices.getCategory();
        log.info("get Category success");

        return response;
    }


}
