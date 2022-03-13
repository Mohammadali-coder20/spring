package org.MohammadAli.services;

import org.MohammadAli.data.CartDAO;
import org.MohammadAli.data.entities.Cart;
import org.MohammadAli.data.entities.CartItem;
import org.MohammadAli.models.CartDTO;
import org.MohammadAli.models.CartItemDTO;
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
    @Transactional
    public CartDTO.RETRIEVE findCartByID(Long cartID) {
        Cart cart = (Cart) cartDAO.findById(cartID).get();
        return mapper.map(cart , CartDTO.RETRIEVE.class);
    }

    @Override
    public void save(CartDTO.CREATE cartDTO) throws IOException {
        Cart cart =  mapper.map(cartDTO ,Cart.class);
        cartDAO.save(cart);
        cartDTO.setCartId(cart.getCartId());
    }

    @Override
    public List<CartDTO.RETRIEVE> findAll() {
        return null;
    }

    @Override
    public void delete(CartDTO.DELETE deleteDTO) {

    }

    @Override
    public void update(CartDTO.RETRIEVE cart) {
        cartDAO.save(mapper.map(cart , Cart.class));
    }

    @Override
    public void removeCartItem(CartItemDTO.RETRIEVE nextCartItem) {
        cartDAO.removeCartItem(mapper.map(nextCartItem , CartItem.class));
    }

    @Override
    public void clearCartItems(Long cartID) {
        cartDAO.clearCartItem(cartID);
    }
}
