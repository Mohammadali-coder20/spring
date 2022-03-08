package org.MohammadAli.data;

import org.MohammadAli.data.entities.Cart;
import org.MohammadAli.data.entities.CartItem;
import org.MohammadAli.models.CartDTO;

import java.util.List;

public interface CartDAO {

    void save(Cart cart);

    List<Cart> findALl();

    void delete(int id);

    Cart findCartByID(Long cartID);

    void update(Cart cart);

    void removeCartItem(CartItem cartItem);

    void clearCartItem(Long cartID);
}
