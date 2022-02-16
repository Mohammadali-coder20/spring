package org.MohammadAli.services;

import org.MohammadAli.models.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    void save(ProductDTO dto);

    List<ProductDTO> findAll();

    void delete(ProductDTO.DELETE deleteDTO);
}
