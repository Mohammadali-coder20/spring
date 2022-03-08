package org.MohammadAli.data;

import org.MohammadAli.data.entities.CartItem;
import org.MohammadAli.models.CartItemDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void update(CartItem cartItem) {
        entityManager.merge(cartItem);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void remove(Long productID) {
//        Session session = getSession();
//        session.createQuery("delete from CartItem c where c.id = :cid").setParameter("cid",productID);
//        session.close();

        CartItem cartItem = entityManager.find(CartItem.class, productID);
        entityManager.remove(cartItem);
        entityManager.close();
//        entityManager.flush();


    }

    Session getSession(){
        return sessionFactory.openSession();
    }


}
