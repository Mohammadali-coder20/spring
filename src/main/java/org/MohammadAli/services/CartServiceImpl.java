package org.MohammadAli.services;

import org.MohammadAli.data.CartDAO;
import org.MohammadAli.data.entities.Cart;
import org.MohammadAli.models.CartDTO;
import org.MohammadAli.models.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService{


    @Autowired
    CartDAO cartDAO;

    @Autowired
    ModelMapper mapper;

    @Override
    public void save(CartDTO.CREATE cartDTO) throws IOException {
        Cart cart =  mapper.map(cartDTO ,Cart.class);
//        CustomerDTO.CREATE customerDTO = (CustomerDTO.CREATE) cartDTO.getCustomer();
//        cart.getCustomer().setCustomerID(customerDTO.getCustomerID());
        cartDAO.save(cart);
    }

    @Override
    public List<CartDTO.RETRIEVE> findAll() {
        return null;
    }

    @Override
    public void delete(CartDTO.DELETE deleteDTO) {

    }
}
