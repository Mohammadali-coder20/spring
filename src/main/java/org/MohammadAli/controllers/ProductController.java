package org.MohammadAli.controllers;


import org.MohammadAli.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    List<ProductDTO> list = new ArrayList<ProductDTO>(){{
        add(new ProductDTO(41,"glass",1000));
        add(new ProductDTO(29,"brill",2000));
    }};

    final static Logger logger= Logger.getLogger(ProductController.class);

    @GetMapping(value = "/add")
    public String add(){
        return "product-add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(ProductDTO productDTO){

        SecureRandom random = new SecureRandom();
        productDTO.setId(random.nextInt());
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



//    @GetMapping(value = "/detail")
//    public String detailWithQueryString(int id){
//        return "product-detail";
//    }

    @GetMapping(value = "/detail")
    public String detailWithQueryString(@RequestParam("id") int dummy){
        logger.info(dummy);
        return "product-detail";
    }

    @GetMapping("/detail/{id}")
    public String detailWithPathParameter(@PathVariable("id") int id){
        logger.info(id);
        return "product-detail";
    }



}
