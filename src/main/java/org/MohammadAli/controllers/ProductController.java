package org.MohammadAli.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.MohammadAli.models.ProductDTO;
import org.MohammadAli.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;



@Controller
@RequestMapping("/product")
@Log4j
@AllArgsConstructor
public class ProductController {

    ProductService productService;


    @GetMapping(value = "/add")
    public String add(@ModelAttribute("dto") ProductDTO productDTO, HttpServletRequest request , Locale locale){
//        Locale locale = request.getLocale();
//        locale.getISO3Language();

//        messageSource.getMessage("error.name", new Object[]{} ,new Locale(locale.getCountry()));

        return "product-add";

    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("dto") @Valid ProductDTO.CREATE createDTO , BindingResult result){

        if (result.hasErrors()){
            return "/product-add";
        }

        productService.save(createDTO);

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
        List<ProductDTO> productDTOList =  productService.findAll();
        modelAndView.addObject("list",productDTOList);
        return modelAndView;
    }



//    @GetMapping(value = "/detail")
//    public String detailWithQueryString(int id){
//        return "product-detail";
//    }

    @GetMapping(value = "/detail")
    public String detailWithQueryString(@RequestParam("id") int dummy){
        log.info(dummy);
        return "product-detail";
    }

    @GetMapping("/detail/{id}")
//    @ResponseBody ---> return value dont will be given  to view resolver . the return value will be given to browser
    public String detailWithPathParameter(@PathVariable("id") int id){
        log.info(id);
        return "product-detail";
    }

    @GetMapping("/delete")
    public String delete(ProductDTO.DELETE deleteDTO){
        productService.delete(deleteDTO);
        return "redirect:/product/get-all";
    }

}
