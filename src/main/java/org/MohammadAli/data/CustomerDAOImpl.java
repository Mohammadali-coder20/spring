package org.MohammadAli.data;

import org.MohammadAli.data.entities.Customer;
import org.MohammadAli.models.CustomerDTO;
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
    public List<Customer> findAll() {
//        entityManager.createQuery("select  from Customer").getResultList();
        Session session = getSession();
        List from_customer = session.createQuery("from Customer").list();
        Customer customer = (Customer) from_customer.get(0);
//        customer.getCart().getCartItems();
        session.close();
        return from_customer;
    }

    @Override
    public Customer findOne(long customerID) {
        Customer customer = entityManager.find(Customer.class, customerID);
        entityManager.close();
        return customer;

    }

    @Override
    public Customer findCustomerByUserNameAndPassWord(String username, String password) {
        return null;
    }

    @Override
    public void update(Customer customer) {
//        entityManager.merge(customer);  // in this way the created date will be null because there is no create date in customer in this method
        entityManager.createNativeQuery("update customer  set cartId = ? where customerID = ?").setParameter(1,customer.getCart()).setParameter(2,customer.getCustomerID()).executeUpdate();
//        entityManager.refresh(customer);
        entityManager.close();
    }


    public Session getSession(){
        return sessionFactory.openSession();
    }
}
