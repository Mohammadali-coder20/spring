package org.MohammadAli.services;

import org.MohammadAli.models.CartDTO;

import java.io.IOException;
import java.util.List;

public interface CartService {

    void save(CartDTO.CREATE cartDTO) throws IOException;

    List<CartDTO.RETRIEVE> findAll();

    void delete(CartDTO.DELETE deleteDTO);
}
