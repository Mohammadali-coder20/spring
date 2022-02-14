package org.MohammadAli.controllers;


import org.MohammadAli.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/product")
public class ProductController {

    List<ProductDTO> list = new ArrayList<ProductDTO>(){{
        add(new ProductDTO(41,"glass",1000,"Home"));
        add(new ProductDTO(29,"brill",2000,"Work"));
    }};

    @Autowired
    Logger logger;

    @Autowired
    MessageSource messageSource;


    @GetMapping(value = "/add")
    public String add(@ModelAttribute("dto") ProductDTO productDTO, HttpServletRequest request , Locale locale){
//        Locale locale = request.getLocale();
//        locale.getISO3Language();

//        messageSource.getMessage("error.name", new Object[]{} ,new Locale(locale.getCountry()));


        return "product-add";

    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("dto") @Valid ProductDTO productDTO , BindingResult result){

        if (result.hasErrors()){
            return "/product-add";
        }

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
//    @ResponseBody ---> return value dont will be given  to view resolver . the return value will be given to browser
    public String detailWithPathParameter(@PathVariable("id") int id){
        logger.info(id);
        return "product-detail";
    }
}
