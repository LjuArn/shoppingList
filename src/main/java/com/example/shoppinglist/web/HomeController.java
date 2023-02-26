package com.example.shoppinglist.web;

import com.example.shoppinglist.domain.entity.enums.CategoryNameEnum;
import com.example.shoppinglist.service.ProductService;
import com.example.shoppinglist.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;


    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }


    @GetMapping("/")
    public String index(Model model){
        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("totalPriceOfProducts", productService.totalSumProduct());
        model.addAttribute("drinks",
                productService.findAllProdByCatgName(CategoryNameEnum.DRINK));
        model.addAttribute("food",
                productService.findAllProdByCatgName(CategoryNameEnum.FOOD));
        model.addAttribute("household",
                productService.findAllProdByCatgName(CategoryNameEnum.HOUSEHOLD));
        model.addAttribute("other",
                productService.findAllProdByCatgName(CategoryNameEnum.OTHER));



        return "home";
    }


}
