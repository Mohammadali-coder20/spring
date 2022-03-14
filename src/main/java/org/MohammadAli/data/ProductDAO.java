package org.MohammadAli.data;

import org.MohammadAli.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    List<Product> findAllByProductCategory(String category);

    @Query(value = "select p from Product p where p.productModel like %:searchTerm% or p.productBrand like %:searchTrem% and p.productCategory like %:category%")
    List<Product> findProductByBrandOrModel(@Param("searchTerm") String searchTerm, @Param("category") String category);

    //    @Query(value = "select img from Product p where p.productID  =: id")
    @Query(value = "select img from Product  where productID =:id", nativeQuery = true)
    byte[] retrieveProductImgByID(@Param("id") Long id);
}
