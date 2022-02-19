package org.MohammadAli.data;

import org.MohammadAli.data.entities.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


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
        return null;
    }

    @Override
    public Customer findOne(long customerID) {
        return null;
    }

    @Override
    public Customer findCustomerByUserNameAndPassWord(String username, String password) {
        return null;
    }
}
