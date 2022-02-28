package org.MohammadAli.controllers;


import lombok.AllArgsConstructor;
import org.MohammadAli.models.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRegisterController customerRegister;


    @GetMapping("/customer-update")
    public String customerUpdateGet(CustomerDTO.REGISTER dto , Model model){
//        customerRegister.register(dto , true  , model);
        return "register-customer";
    }

    @PostMapping("/customer-update")
    public void customerUpdatePost(){

    }

    @GetMapping("/cart")
    public String showCustomerCart(){
        return "cart";
    }

}
