package org.MohammadAli.data;

import org.MohammadAli.data.entities.Cart;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}

