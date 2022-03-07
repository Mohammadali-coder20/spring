package org.MohammadAli.services;

import org.MohammadAli.models.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface ProductService {
    void save(ProductDTO.CREATE productDTO) throws IOException;

    List<ProductDTO.RETRIEVE> findAll();

    void delete(ProductDTO.DELETE deleteDTO);

    byte[] retrieveProductImgByID(Long Id);

    ProductDTO.RETRIEVE findProductByID(long productID);

    List<ProductDTO.RETRIEVE> findProductByCategory(String category);

    void remove(Long productID);
}
