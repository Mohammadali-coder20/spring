package org.MohammadAli.services;

import org.MohammadAli.data.ProductDAO;
import org.MohammadAli.data.entities.Product;
import org.MohammadAli.models.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
    public void save(ProductDTO.CREATE productDTO) throws IOException {
        Product product = modelMapper.map(productDTO,Product.class);
        product.setImg(productDTO.getProductImg().getBytes());
        productDAO.save(product);
    }

    @Override
    public List<ProductDTO.RETRIEVE> findAll() {
        List<Product> productList = productDAO.findALl();
        List<ProductDTO.RETRIEVE> productDTOList = productList
                                                     .stream()
                                                     .map(Product -> modelMapper.map(Product,ProductDTO.RETRIEVE.class))
                                                     .collect(Collectors.toList());

        return productDTOList;
    }

    @Override
    public void delete(ProductDTO.DELETE deleteDTO) {
        productDAO.delete(deleteDTO.getProductID());
    }

    @Override
    public byte[] retrieveProductImgByID(Long Id) {
        return productDAO.retrieveProductImgByID(Id);
    }

    @Override
    public ProductDTO.RETRIEVE findProductByID(long productID) {
        Product product = productDAO.findProductBYID(productID);
        ProductDTO.RETRIEVE map = modelMapper.map(product, ProductDTO.RETRIEVE.class);
        map.setCategoryList(new ProductDTO.CREATE().getCategoryList());
        return map;
    }

    @Override
    public List<ProductDTO.RETRIEVE> findProductByCategory(String category) {
        List<Product> productList = productDAO.findProductByCategory(category);
        return productList.stream().map(product -> modelMapper.map(product,ProductDTO.RETRIEVE.class)).collect(Collectors.toList());
    }

    @Override
    public void remove(Long productID) {

    }

    @Override
    public List<ProductDTO.RETRIEVE> findProductByBrandOrModelOrCategory(String searchTerm) {
         List<Product> productList = productDAO.findProductByBrandOrModelOrCategory(searchTerm);
         return productList.stream().map(product -> modelMapper.map(product,ProductDTO.RETRIEVE.class)).collect(Collectors.toList());
    }
}
