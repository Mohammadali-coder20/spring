package org.MohammadAli.controllers;


import org.MohammadAli.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {

    final static Logger logger= Logger.getLogger(ProductController.class);

    @GetMapping("/add")
    public String add(){
        return "product-add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(ProductDTO productDTO){
        logger.info(productDTO);
        return "redirect:/";
    }

}
