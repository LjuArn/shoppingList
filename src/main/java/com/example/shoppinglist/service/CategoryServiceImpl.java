package com.example.shoppinglist.service;

import com.example.shoppinglist.domain.entity.Category;
import com.example.shoppinglist.domain.entity.enums.CategoryNameEnum;
import com.example.shoppinglist.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if(categoryRepository.count() != 0){
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category(categoryNameEnum,
                            "Description for " + categoryNameEnum.name());
                    categoryRepository.save(category);
                });


    }

    @Override
    public Category findByName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
