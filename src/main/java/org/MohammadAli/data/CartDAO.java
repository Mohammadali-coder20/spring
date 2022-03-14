package org.MohammadAli.data;

import org.MohammadAli.data.entities.Cart;
import org.MohammadAli.data.entities.CartItem;
import org.MohammadAli.models.CartDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaEvaluationContextExtension;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDAO extends JpaRepository<Cart , Long> {

    @Modifying
    @Query("delete from CartItem c where c.cartItemID = :cartItemID")
    void removeCartItem(@Param("cartItemID") Long cartItemID);


    @Modifying
    @Query("delete from CartItem c where c.cart.cartId = :cartID")
    void clearCartItem(@Param("cartID") Long cartID);
}
