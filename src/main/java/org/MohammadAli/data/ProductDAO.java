package org.MohammadAli.data;

import org.MohammadAli.data.entities.Product;


import java.util.List;


public interface ProductDAO {
    void save(Product product);

    List<Product> findALl();

    void delete(Long id);

    byte[] retrieveProductImgByID(Long Id);

    Product findProductBYID(long productID);

    List<Product> findProductByCategory(String category);

    List<Product> findProductByBrandOrModelOrCategory(String searchTerm);

    void update(Product product);
}
