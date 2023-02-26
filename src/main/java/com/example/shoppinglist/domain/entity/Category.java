package com.example.shoppinglist.domain.entity;


import com.example.shoppinglist.domain.entity.enums.CategoryNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public Category(CategoryNameEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
