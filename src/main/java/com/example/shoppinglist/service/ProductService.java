package com.example.shoppinglist.service;

import com.example.shoppinglist.domain.entity.enums.CategoryNameEnum;
import com.example.shoppinglist.domain.serviceModel.ProductAddServiceModel;
import com.example.shoppinglist.domain.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addProduct(ProductAddServiceModel productAddServiceModel);

    BigDecimal totalSumProduct();

    List<ProductViewModel> findAllProdByCatgName(CategoryNameEnum categoryNameEnum);

    void buy(Long id);

    void buyAllProducts();
}
