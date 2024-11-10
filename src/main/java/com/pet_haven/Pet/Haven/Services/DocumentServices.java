package com.pet_haven.Pet.Haven.Services;

import com.pet_haven.Pet.Haven.Entity.ProductEntity;
import com.pet_haven.Pet.Haven.Repository.ProductRepo;
import com.pet_haven.Pet.Haven.Services.domain.productsReq;
import com.pet_haven.Pet.Haven.Util.GenericResponse;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class DocumentServices {
    private final ProductRepo productRepo;

    public GenericResponse<ProductEntity> saveProducts(productsReq productsReq) {
        ProductEntity productEntity = new ProductEntity();

        productsReq.setRowid(UUID.randomUUID().toString());
        BeanUtils.copyProperties(productsReq, productEntity);

        productEntity.setCreatedAt(LocalDateTime.now());
        productEntity.setUpdatedAt(LocalDateTime.now());

        productRepo.save(productEntity);

        return new GenericResponse<>(HttpStatus.CREATED, "Product created successfully", productEntity);
    }

    public GenericResponse<List<ProductEntity>> getProducts() {
        List<ProductEntity> products = productRepo.findAll();

        return new GenericResponse<>(HttpStatus.OK, "Get Products successfully", products);
    }

}
