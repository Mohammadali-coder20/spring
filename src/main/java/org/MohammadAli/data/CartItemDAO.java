package org.MohammadAli.data;

import org.MohammadAli.data.entities.CartItem;
import org.MohammadAli.models.CartItemDTO;

import java.util.List;

public interface CartItemDAO {

    void save(CartItem cartItem);

    List<CartItem> findALl();


    void update(CartItem cartItem);

    void remove(Long productID);
}
