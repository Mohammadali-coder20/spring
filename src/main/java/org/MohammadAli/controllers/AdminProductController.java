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
        return "redirect:/admin/productManagement/1";
    }

    @ResponseBody
    @GetMapping(value = "/get-image/{imgID}" , produces = "image/jpeg")
    public byte[] getImgByID(@PathVariable("imgID") Long imgID){

        return productService.retrieveProductImgByID(imgID);
    }

}
