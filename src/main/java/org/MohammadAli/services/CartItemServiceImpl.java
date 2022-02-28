package org.MohammadAli.services;

import org.MohammadAli.data.CartItemDAO;
import org.MohammadAli.data.entities.CartItem;
import org.MohammadAli.models.CartItemDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemDAO cartItemDAO;

    @Autowired
    ModelMapper mapper;

    @Override
    public void save(CartItemDTO.CREATE cartItemDTO) throws IOException {
        CartItem cartItem = mapper.map(cartItemDTO, CartItem.class);
        cartItemDAO.save(cartItem);
    }

    @Override
    public List<CartItemDTO.RETRIEVE> findAll() {
        return null;
    }

    @Override
    public void delete(CartItemDTO.DELETE deleteDTO) {

    }
}
