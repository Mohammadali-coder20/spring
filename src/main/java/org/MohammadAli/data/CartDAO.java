package org.MohammadAli.data;

import org.MohammadAli.data.entities.Cart;
import org.MohammadAli.data.entities.CartItem;
import org.MohammadAli.models.CartDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaEvaluationContextExtension;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDAO extends JpaRepository {

    @Query("delete from Cart c where c.cartItems =:cartItem")
    void removeCartItem(@Param("cartItem") CartItem cartItem);

    @Query("delete from Cart c where c.cartId =: cartID")
    void clearCartItem(@Param("cartID") Long cartID);
}
