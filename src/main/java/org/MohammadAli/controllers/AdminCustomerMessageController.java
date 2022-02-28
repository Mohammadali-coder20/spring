package org.MohammadAli.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/customer-message")
@AllArgsConstructor
public class AdminCustomerMessageController {

//    @GetMapping("/{pageIndex}")
//    public String showCustomerMessage(@PathVariable("pageIndex") Integer pageIndex){
//        return "";
//    }

    @GetMapping("/delete-message")
    public String deleteMessage(){
        return "";
    }


}
