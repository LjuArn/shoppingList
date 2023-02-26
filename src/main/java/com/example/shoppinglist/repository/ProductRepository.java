package com.example.shoppinglist.repository;

import com.example.shoppinglist.domain.entity.Product;
import com.example.shoppinglist.domain.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT SUM (p.price) from Product p")
    BigDecimal findAllProductsSum();

   List<Product> findAllByCategory_Name(CategoryNameEnum category_name);
}
