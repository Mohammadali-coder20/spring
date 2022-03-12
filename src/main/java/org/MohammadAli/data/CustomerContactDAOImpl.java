package org.MohammadAli.data;


import org.MohammadAli.data.entities.CustomerContact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerContactDAOImpl implements CustomerContactDAO {

    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void save(CustomerContact customerContact) {
        Session session = getSession();
        session.save(customerContact);
//        session.persist(customerContact);
        session.close();
//        session.flush();
    }

    @Override
    public List<CustomerContact> findALl() {
        try(Session session = getSession()){
            List customerContact = session.createQuery("from CustomerContact").getResultList();
            return customerContact;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        CustomerContact customerContact = entityManager.find(CustomerContact.class, id);
        entityManager.remove(customerContact);
        entityManager.flush();
    }

    Session getSession(){
        return sessionFactory.openSession();
    }
}
