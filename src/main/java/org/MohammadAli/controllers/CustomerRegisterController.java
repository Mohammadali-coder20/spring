package org.MohammadAli.controllers;

import lombok.AllArgsConstructor;
import org.MohammadAli.models.CustomerDTO;
import org.MohammadAli.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerRegisterController {


    private CustomerService customerService;

    @GetMapping("/register")
    public String register(@ModelAttribute("customer") CustomerDTO.REGISTER registerDTO){

        return "register-customer";
    }


    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customer") CustomerDTO.CREATE createDTO , BindingResult result){
        if (result.hasErrors()) {
            return "register-customer";
        }
        customerService.addCustomer(createDTO);
        return "registerCustomerSuccess";
    }
}
