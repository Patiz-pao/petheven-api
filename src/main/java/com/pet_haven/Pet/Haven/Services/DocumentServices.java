package com.pet_haven.Pet.Haven.Services;

import com.pet_haven.Pet.Haven.Entity.CategoryEntity;
import com.pet_haven.Pet.Haven.Entity.ProductEntity;
import com.pet_haven.Pet.Haven.Repository.CategoryRepo;
import com.pet_haven.Pet.Haven.Repository.ProductRepo;
import com.pet_haven.Pet.Haven.Services.domain.CategoryReq;
import com.pet_haven.Pet.Haven.Services.domain.ProductsReq;
import com.pet_haven.Pet.Haven.Util.GenericResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class DocumentServices {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    private String generateNewSku() {
        ProductEntity lastProduct = productRepo.findTopByOrderByCreatedAtDesc();
        String lastSku = (lastProduct != null) ? lastProduct.getSku() : "PD-000";

        int lastSkuNumber = Integer.parseInt(lastSku.substring(3));

        int newSkuNumber = lastSkuNumber + 1;
        return "PD-" + String.format("%03d", newSkuNumber);
    }

    public GenericResponse<ProductEntity> saveProducts(ProductsReq productsReq) {
        ProductEntity productEntity = new ProductEntity();

        productsReq.setRowid(UUID.randomUUID().toString());
        BeanUtils.copyProperties(productsReq, productEntity);

        productEntity.setCreatedAt(LocalDateTime.now());
        productEntity.setUpdatedAt(LocalDateTime.now());

        productEntity.setSku(generateNewSku());

        productRepo.save(productEntity);

        return new GenericResponse<>(HttpStatus.CREATED, "Product created successfully", productEntity);
    }

    public GenericResponse<String> deleteProduct(String rowid) {
        Optional<ProductEntity> productEntityOpt = productRepo.findById(rowid);
        if (productEntityOpt.isPresent()) {
            productRepo.delete(productEntityOpt.get());
            return new GenericResponse<>(HttpStatus.OK, "Product deleted successfully", "Product with ID: " + rowid + " deleted.");
        } else {
            return new GenericResponse<>(HttpStatus.NOT_FOUND, "Product not found", "No product found with ID: " + rowid);
        }
    }

    public GenericResponse<List<ProductEntity>> getProducts() {
        List<ProductEntity> products = productRepo.getAllProduct();

        return new GenericResponse<>(HttpStatus.OK, "Get Products successfully", products);
    }

    public GenericResponse<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = productRepo.getAllProductAdmin();

        return new GenericResponse<>(HttpStatus.OK, "Get All Products successfully", products);
    }

    public GenericResponse<ProductEntity> getProductsById(String rowId) {
        ProductEntity products = productRepo.findByRowid(rowId);

        return new GenericResponse<>(HttpStatus.OK, "Get ProductsById successfully", products);
    }

    public GenericResponse<ProductEntity> updateProduct(String rowId, ProductsReq productsReq) {
        ProductEntity products = productRepo.findByRowid(rowId);

        if (products == null) {
            return new GenericResponse<>(HttpStatus.NOT_FOUND, "Product not found", null);
        }
        products.setRowid(rowId);
        products.setName(productsReq.getName());
        products.setDescription(productsReq.getDescription());
        products.setPrice(productsReq.getPrice());
        products.setCategory(productsReq.getCategory());
        products.setStockQuantity(productsReq.getStockQuantity());
        products.setImageUrl(productsReq.getImageUrl());
        products.setSku(productsReq.getSku());
        products.setBrand(productsReq.getBrand());
        products.setRating(productsReq.getRating());
        products.setDiscountPrice(productsReq.getDiscountPrice());
        products.setUpdatedAt(LocalDateTime.now());

        productRepo.save(products);

        return new GenericResponse<>(HttpStatus.OK, "Product updated successfully", products);
    }

    public GenericResponse<ProductEntity> updateStatus(String rowId,String status, ProductsReq productsReq) {
        ProductEntity products = productRepo.findByRowid(rowId);

        if (products == null) {
            return new GenericResponse<>(HttpStatus.NOT_FOUND, "Product not found", null);
        }
        products.setRowid(rowId);
        products.setStatus(status);

        productRepo.save(products);

        return new GenericResponse<>(HttpStatus.OK, "Product updated successfully", products);
    }

    public GenericResponse<CategoryEntity> saveCategory(CategoryReq categoryReq) {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryReq.setRowid(UUID.randomUUID().toString());
        BeanUtils.copyProperties(categoryReq, categoryEntity);

        categoryRepo.save(categoryEntity);

        return new GenericResponse<>(HttpStatus.CREATED, "Category created successfully", categoryEntity);
    }

    public GenericResponse<List<CategoryEntity>> getCategory() {
        List<CategoryEntity> category = categoryRepo.findAll();

        return new GenericResponse<>(HttpStatus.OK, "Get Category successfully", category);
    }


}
