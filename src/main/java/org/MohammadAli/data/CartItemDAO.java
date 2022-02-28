package org.MohammadAli.data;

import org.MohammadAli.data.entities.CartItem;

import java.util.List;

public interface CartItemDAO {

    void save(CartItem cartItem);

    List<CartItem> findALl();

    void delete(int id);

}
