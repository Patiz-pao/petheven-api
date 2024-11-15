package com.pet_haven.Pet.Haven.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column(name = "row_id")
    private String rowid;

    @Column(name = "name")
    private String name;
}
