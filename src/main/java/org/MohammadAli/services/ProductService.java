package org.MohammadAli.services;

import org.MohammadAli.models.ProductDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface ProductService {
    void save(ProductDTO dto) throws IOException;

    List<ProductDTO> findAll();

    void delete(ProductDTO.DELETE deleteDTO);
}
