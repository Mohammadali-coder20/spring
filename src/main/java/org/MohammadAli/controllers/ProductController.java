package org.MohammadAli.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.MohammadAli.models.ProductDTO;
import org.MohammadAli.services.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @GetMapping("/product-list/{category}/{pageNumber}")
    public String showAllProductByCategory(
              @PathVariable("category") String category
            , @RequestParam("pageNumber") int pageNumber
            , Model model) {

        List<ProductDTO.RETRIEVE> productList;
//        PageRequest pageRequest = (category.equals("all")) ? PageRequest.of(page, size) : PageRequest.of(page, size, Sort.by("productName")) ;
        if (category.equals("all"))
            productList = productService.findAll(pageNumber);
        else
            productList = productService.findProductByCategory(category, pageNumber);
        model.addAttribute("totalPages", 10);
        model.addAttribute("currentPageNumber", 10);
        model.addAttribute("productCategory", category);
        model.addAttribute("products", productList);
        return "product-list";
    }

    @GetMapping("/view-product-detail/{productID}")
    public String showProductDetail(@PathVariable("productID") long productID, Model model) {
        ProductDTO.RETRIEVE dto = productService.findProductByID(productID);
        model.addAttribute("product", dto);
        return "product-detail";
    }
}
