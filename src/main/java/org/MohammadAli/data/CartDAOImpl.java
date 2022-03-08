package org.MohammadAli.data;

import org.MohammadAli.data.entities.Cart;
import org.MohammadAli.data.entities.CartItem;
import org.MohammadAli.models.CartDTO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Repository
public class CartDAOImpl  implements CartDAO {

    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void save(Cart cart) {
        entityManager.persist(cart);
        entityManager.flush();
    }

    @Override
    public List<Cart> findALl() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Cart findCartByID(Long cartID) {
        Cart cart = entityManager.find(Cart.class, cartID);
        entityManager.flush();
        return cart;
    }

    @Override
    @Transactional
    public void update(Cart cart) {
        entityManager.merge(cart);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void removeCartItem(CartItem cartItem) {
        Cart cart = entityManager.find(Cart.class, cartItem.getCart().getCartId());
        cart.getCartItems().remove(cartItem);
        entityManager.flush();
        entityManager.clear();
    }

    @Override
    @Transactional
    public void clearCartItem(Long cartID) {
        Cart cart = entityManager.find(Cart.class, cartID);
        List<CartItem> cartItems = cart.getCartItems();
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
        entityManager.flush();
        entityManager.clear();
    }
}

