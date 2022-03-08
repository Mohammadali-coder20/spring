package org.MohammadAli.controllers;

import lombok.AllArgsConstructor;
import org.MohammadAli.models.ProductDTO;
import org.MohammadAli.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

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

    @GetMapping("/search-product/{pageNumber}")
    public String searchProduct(@PathVariable("pageNumber") int pageNumber , @RequestParam("searchTerm") String searchTerm , Model model){
        List<ProductDTO.RETRIEVE> productList =  productService.findProductByBrandOrModelOrCategory(searchTerm);
        model.addAttribute("products", productList);
        return "product-inventory";
    }

    @RequestMapping(value = "/delete-product/{productID}", method = RequestMethod.POST)
    public String deleteProduct(@PathVariable("productID") Long productID){
        productService.remove(productID);
        return "redirect:/admin/product-management/1";
    }

}
