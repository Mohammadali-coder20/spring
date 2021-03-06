package org.MohammadAli.services;

import org.MohammadAli.models.CartItemDTO;
import org.MohammadAli.models.UserDTO;

import java.io.IOException;
import java.util.List;

public interface CartItemService {

    void save(CartItemDTO.CREATE cartItemDTO) throws IOException;

    List<CartItemDTO.RETRIEVE> findAll();

    void delete(CartItemDTO.DELETE deleteDTO);
}
