package org.MohammadAli.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.MohammadAli.models.ProductDTO;
import org.MohammadAli.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @GetMapping("/product-list/{category}/{pageIndex}")
    public String showAllProductByCategory(@PathVariable("category") String category, @PathVariable("pageIndex") String pageIndex , Model model){
        List<ProductDTO.RETRIEVE> productList;
        if (category.equals("all"))
            productList = productService.findAll();
        else
            productList = productService.findProductByCategory(category);

        model.addAttribute("products", productList);
        return "product-list";
    }

    @GetMapping("/view-product-detail/{productID}")
    public String showProductDetail(@PathVariable("productID") long productID , Model model){
        ProductDTO.RETRIEVE dto = productService.findProductByID(productID);
        model.addAttribute("product", dto);
        return "product-detail";
    }



}
