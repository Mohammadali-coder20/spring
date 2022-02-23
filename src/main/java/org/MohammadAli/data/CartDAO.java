package org.MohammadAli.data;

import org.MohammadAli.data.entities.Cart;

import java.util.List;

public interface CartDAO {

    void save(Cart cart);

    List<Cart> findALl();

    void delete(int id);
}
