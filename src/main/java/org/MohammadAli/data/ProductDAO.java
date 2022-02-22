package org.MohammadAli.data;

import org.MohammadAli.data.entities.Product;


import java.util.List;


public interface ProductDAO {
    void save(Product product);

    List<Product> findALl();

    void delete(int id);

    byte[] retrieveProductImgByID(Long Id);
}
