package com.example.shoppinglist.service;

import com.example.shoppinglist.domain.entity.Product;
import com.example.shoppinglist.domain.entity.enums.CategoryNameEnum;
import com.example.shoppinglist.domain.serviceModel.ProductAddServiceModel;
import com.example.shoppinglist.domain.view.ProductViewModel;
import com.example.shoppinglist.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private  final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryService categoryService,
                              ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addProduct(ProductAddServiceModel productAddServiceModel) {

        Product product = modelMapper.map(productAddServiceModel, Product.class);

        product.setCategory(categoryService.findByName(productAddServiceModel.getCategory()));
        productRepository.save(product);
    }

    @Override
    public BigDecimal totalSumProduct() {
        return productRepository.findAllProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllProdByCatgName(CategoryNameEnum categoryNameEnum) {
        return productRepository.findAllByCategory_Name(categoryNameEnum)
                .stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buy(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAllProducts() {
        productRepository.deleteAll();
    }
}
