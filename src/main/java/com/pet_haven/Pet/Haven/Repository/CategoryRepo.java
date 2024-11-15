package com.pet_haven.Pet.Haven.Repository;

import com.pet_haven.Pet.Haven.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity, String> {
}
