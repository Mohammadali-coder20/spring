package org.MohammadAli.data;

import java.util.List;

public interface CartItemDAO {

    void save(CartItemDAO cartItemDAO);

    List<CartItemDAO> findALl();

    void delete(int id);

}
