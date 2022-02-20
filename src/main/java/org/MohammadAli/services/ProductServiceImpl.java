package org.MohammadAli.services;

import org.MohammadAli.data.ProductDAO;
import org.MohammadAli.data.entities.Product;
import org.MohammadAli.models.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{


    @Autowired
    ProductDAO productDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(ProductDTO dto) throws IOException {
        Product product = new Product();
        product = modelMapper.map(dto,Product.class);
        product.setImg(dto.getProductImg().getBytes());
        productDAO.save(product);


    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = productDAO.findALl();
        List<ProductDTO> productDTOList = productList
                                                     .stream()
                                                     .map(Product -> modelMapper.map(Product,ProductDTO.class))
                                                     .collect(Collectors.toList());
        return productDTOList;
    }

    @Override
    public void delete(ProductDTO.DELETE deleteDTO) {
        productDAO.delete(deleteDTO.getId());
    }
}
