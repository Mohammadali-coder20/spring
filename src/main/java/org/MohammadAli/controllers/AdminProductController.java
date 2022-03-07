package org.MohammadAli.controllers;

import lombok.AllArgsConstructor;
import org.MohammadAli.models.ProductDTO;
import org.MohammadAli.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/admin/product")
@AllArgsConstructor
public class AdminProductController {


    ProductService productService;

    @GetMapping("/add-product")
    public String addProduct(@ModelAttribute("product") ProductDTO.CREATE createDTO){

        createDTO.setProductStatus("Brand New");

        return "add-product";
    }

    @PostMapping("/save-product")
    public String saveProduct(@Valid @ModelAttribute("product") ProductDTO.CREATE createDTO , BindingResult result) throws IOException {

        if (result.hasErrors())
            return  "add-product";

        productService.save(createDTO);
        return "redirect:/admin/product-management/1";
    }


    @GetMapping("/search-product/{product-category}/{product-brand}/{product-model}")
    public String searchProduct(@RequestParam("product-category") String category,
                                @RequestParam("product-brand") String brand,
                                @RequestParam("product-model") String model){

        return "";
    }

}
