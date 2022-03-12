package org.MohammadAli.controllers;

import java.util.*;

import lombok.AllArgsConstructor;
import org.MohammadAli.models.CustomerContactDTO;
import org.MohammadAli.models.CustomerDTO;
import org.MohammadAli.models.CustomerOrderDTO;
import org.MohammadAli.models.ProductDTO;
import org.MohammadAli.services.CustomerContactService;
import org.MohammadAli.services.CustomerOrderService;
import org.MohammadAli.services.CustomerService;
import org.MohammadAli.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private ProductService productService;
    private CustomerService customerService;
    private CustomerOrderService customerOrderService;
    private CustomerContactService customerContactService;


    @GetMapping("/admin-panel")
    public String admin() {
        return "admin-panel";
    }


    @GetMapping("/product-management/{pageNumber}")
    public String productManagement(@PathVariable Integer pageNumber, Model model) {

        List<ProductDTO.RETRIEVE> productDTOList = productService.findAll();
        model.addAttribute("products", productDTOList);
        return "product-inventory";
    }


    @RequestMapping(value = "/customer-management", method = RequestMethod.GET)
    public String customerManagement(Model model) {

        List<CustomerDTO.RETRIEVE> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "customer-management";
    }


    @RequestMapping(value = "/customer-order", method = RequestMethod.GET)
    public String customerOrder(Model model) {

        List<CustomerOrderDTO.RETRIEVE> orderList = customerOrderService.findAll();
        model.addAttribute("orders", orderList);
        return "customer-order-list";
    }


    @RequestMapping(value = "/customer-message/{pageIndex}", method = RequestMethod.GET)
    public String customerMessage(@PathVariable Integer pageIndex, Model model) {
        List<CustomerContactDTO.RETRIEVE> all = customerContactService.findAll();
        if (all.size() != 0)
            model.addAttribute("customerContacts", all);
        else
            model.addAttribute("msg", "There are no messages from any users");
        return "customer-message";
    }


}
