package com.pet_haven.Pet.Haven.Services.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class productsReq {

    private String rowid;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private int stockQuantity;
    private String imageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    private String sku;
    private String brand;
    private BigDecimal rating;
    private BigDecimal discountPrice;
    private Boolean isFeatured;

}
