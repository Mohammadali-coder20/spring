package org.MohammadAli.controllers;

import java.util.*;
import lombok.AllArgsConstructor;
import org.MohammadAli.models.ProductDTO;
import org.MohammadAli.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private ProductService productService;


    @GetMapping("/page")
    public String admin(){
        return "admin";
    }

    @GetMapping("/productManagement/{pageNumber}")
    public String productManagement(@PathVariable Integer pageNumber , Model model){

        List<ProductDTO.RETRIEVE> productDTOList = productService.findAll();
        model.addAttribute("products",productDTOList);
        return "product-Inventory";
    }

    @GetMapping("/product/search-product/{product-category}/{product-brand}/{product-model}")
    public String searchProduct(@RequestParam("product-category") String category,
                                @RequestParam("product-brand") String brand,
                                @RequestParam("product-model") String model){
        return "";
    }

}
