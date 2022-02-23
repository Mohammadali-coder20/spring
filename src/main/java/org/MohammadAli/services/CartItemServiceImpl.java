package org.MohammadAli.services;

import org.MohammadAli.models.CartItemDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {


    @Override
    public void save(CartItemDTO.CREATE cartItemDTO) throws IOException {

    }

    @Override
    public List<CartItemDTO.RETRIEVE> findAll() {
        return null;
    }

    @Override
    public void delete(CartItemDTO.DELETE deleteDTO) {

    }
}
