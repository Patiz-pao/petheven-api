package com.pet_haven.Pet.Haven.Repository;

import com.pet_haven.Pet.Haven.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, String> {
}
