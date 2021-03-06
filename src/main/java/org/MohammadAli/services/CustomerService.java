package org.MohammadAli.services;

import org.MohammadAli.models.CustomerDTO;
import java.util.List;


public interface CustomerService {

    void addCustomer(CustomerDTO.CREATE customerDTO);

    CustomerDTO findCustomerByUserName(String userName);

    List<CustomerDTO.LOGIN> getAllCustomerForLogin();

    CustomerDTO.ADDRESS getCustomerByCustomerID(long customerId);

    CustomerDTO findCustomerByUserNameAndPassWord(String username, String password);

    void updateCustomer(CustomerDTO.CREATE customerDTO);

    List<CustomerDTO.RETRIEVE> findAll();
}
