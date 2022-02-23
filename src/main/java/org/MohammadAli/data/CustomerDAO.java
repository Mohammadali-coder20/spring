package org.MohammadAli.data;

import org.MohammadAli.data.entities.Customer;

import java.util.List;

public interface CustomerDAO {
    void save(Customer customer);

    Customer findUserByUserName(String username);

    List<Customer> getAll();

    Customer findOne(long customerID);

    Customer findCustomerByUserNameAndPassWord(String username , String password);

}
