package org.MohammadAli.controllers;

import java.util.*;

import lombok.AllArgsConstructor;
import org.MohammadAli.models.*;
import org.MohammadAli.services.CustomerContactService;
import org.MohammadAli.services.CustomerOrderService;
import org.MohammadAli.services.CustomerService;
import org.MohammadAli.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    @Autowired
    private ProductService productService;
    private CustomerService customerService;
    private CustomerOrderService customerOrderService;
    private CustomerContactService customerContactService;


    @Autowired
    Pagination<ProductDTO.RETRIEVE> pagination;


    @GetMapping("/admin-panel")
    public String admin() {
        return "admin-panel";
    }


    @GetMapping("/product-management/{pageNumber}")
    public String productManagement(@PathVariable("pageNumber") Integer pageNumber, @Autowired Pagination<ProductDTO.RETRIEVE> pagination, Model model) {
        List<ProductDTO.RETRIEVE> all = productService.findAll(pageNumber-1, pagination);
        model.addAttribute("products", all);
        model.addAttribute("beginIndex", Math.max(1, pageNumber - 5));
        model.addAttribute("endIndex", Math.min(pageNumber + 10, pagination.getTotalPages()));
        model.addAttribute("totalPages", pagination.getTotalPages());
        model.addAttribute("currentPageNumber", pageNumber);
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


    @RequestMapping(value = "/customer-message/{pageNumber}", method = RequestMethod.GET)
    public String customerMessage(@PathVariable Integer pageNumber, Model model) {
        List<CustomerContactDTO.RETRIEVE> all = customerContactService.findAll();
        if (all.size() != 0)
            model.addAttribute("customerContacts", all);
        else
            model.addAttribute("msg", "There are no messages from any users");
        return "customer-message";
    }

}
