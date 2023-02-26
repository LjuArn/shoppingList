package com.example.shoppinglist.web;

import com.example.shoppinglist.domain.binding.ProductAddBindingModel;
import com.example.shoppinglist.domain.serviceModel.ProductAddServiceModel;
import com.example.shoppinglist.service.ProductService;
import com.example.shoppinglist.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public ProductController(ProductService productService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @GetMapping("/add")
    public String add() {

        if (currentUser.getId() == null) {
            return "redirect:/login";
        }

        return "product-add";
    }

    @ModelAttribute
    public ProductAddBindingModel orderAddBindingModel() {
        return new ProductAddBindingModel();
    }

    /* @GetMapping("/add")
      public String add(Model model){
         if(!model.containsAttribute("productAddBindingModel")){
             model.addAttribute("productAddBindingModel", new ProductAddBindingModel());
         }
          return "product-add";
      }
  */

    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }


        productService.addProduct(modelMapper.map(productAddBindingModel, ProductAddServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id) {
        productService.buy(id);
        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll() {
        productService.buyAllProducts();
        return "redirect:/";
    }


}
