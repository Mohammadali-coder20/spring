package org.MohammadAli.data;


import org.MohammadAli.data.entities.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerOrderDAOImpl implements CustomerOrderDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void save(CustomerOrder customerOrderDAO) {

    }

    @Override
    public List<CustomerOrder> findALl() {
        try(Session session = getSession()) {
            return session.createQuery("from CustomerOrder").getResultList();
        }
    }

    @Override
    public void delete(int id) {

    }

    public Session getSession(){
        return sessionFactory.openSession();
    }









}
