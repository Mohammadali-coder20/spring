package org.MohammadAli.controllers;

import org.MohammadAli.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product/rest")
public class ProductRestService {


    final static Logger logger= Logger.getLogger(ProductController.class);

    List<ProductDTO> list = new ArrayList<ProductDTO>(){{
        add(new ProductDTO(41,"glass",1000));
        add(new ProductDTO(29,"brill",2000));
    }};

    @GetMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO detailWithPathParameter(@PathVariable("id") int id){
        logger.info(id);
        return list.get(0);
    }

}
