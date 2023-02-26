package com.example.shoppinglist.service;

import com.example.shoppinglist.domain.entity.Category;
import com.example.shoppinglist.domain.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryNameEnum categoryNameEnum);
}
