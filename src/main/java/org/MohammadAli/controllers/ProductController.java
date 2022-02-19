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



}
