package org.MohammadAli.data;

import org.MohammadAli.data.entities.CartItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CartItemDAOImpl implements CartItemDAO{

    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(CartItem cartItem) {
        entityManager.persist(cartItem);
        entityManager.close();
    }

    @Override
    public List<CartItem> findALl() {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
