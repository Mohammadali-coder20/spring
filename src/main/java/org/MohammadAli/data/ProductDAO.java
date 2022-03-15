package org.MohammadAli.data;

import org.MohammadAli.data.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    Page<Product> findAllByProductCategory(String category , Pageable pageable);

    @Query(value = "select p from Product p where p.productModel like %:searchTerm% or p.productBrand like %:searchTrem% and p.productCategory like %:category%")
    Page<Product> findProductByBrandOrModel(@Param("searchTerm") String searchTerm, @Param("category") String category , Pageable pageable);

    //    @Query(value = "select img from Product p where p.productID  =: id")
    @Query(value = "select img from Product  where productID =:id", nativeQuery = true)
    byte[] retrieveProductImgByID(@Param("id") Long id);
}
