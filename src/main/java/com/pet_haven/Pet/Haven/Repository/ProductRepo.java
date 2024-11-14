package com.pet_haven.Pet.Haven.Repository;

import com.pet_haven.Pet.Haven.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductEntity, String> {
    ProductEntity findTopByOrderByCreatedAtDesc();

    ProductEntity findByRowid(String rowId);

    @Query("SELECT p FROM ProductEntity p ORDER BY p.createdAt DESC")
    List<ProductEntity> findAllOrderByCreatedAtDesc();
}
