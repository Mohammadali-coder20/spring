package org.MohammadAli.data;

import org.MohammadAli.data.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);
        entityManager.close();
    }

    @Override
    public Customer findUserByUserName(String username) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
//        entityManager.createQuery(" Customer").getResultList();
        Session session = getSession();
        List from_customer = session.createQuery("from Customer").list();
        session.close();
        return from_customer;
    }

    @Override
    public Customer findOne(long customerID) {
        return null;
    }

    @Override
    public Customer findCustomerByUserNameAndPassWord(String username, String password) {
        return null;
    }


    public Session getSession(){
        return sessionFactory.openSession();
    }
}
