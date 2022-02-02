package org.MohammadAli.controllers;


import org.MohammadAli.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    List<ProductDTO> list = new ArrayList<>();

    final static Logger logger= Logger.getLogger(ProductController.class);

    @GetMapping(value = "/add")
    public String add(){
        return "product-add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(ProductDTO productDTO){
        logger.info(productDTO);
        list.add(productDTO);
        return "redirect:/";
    }

//    @GetMapping(value = "/get-all")
//    public String getAll(Model model){
//        model.addAttribute("products",list);
//        return "product-list";
//    }

    @GetMapping(value = "/get-all")
    public ModelAndView getAll(ModelAndView modelAndView){
        modelAndView.setViewName("product-list");
        modelAndView.getModelMap().addAttribute("products",list);
        return modelAndView;
    }
}
