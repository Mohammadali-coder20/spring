package org.MohammadAli.services;

import org.MohammadAli.data.CustomerDAO;
import org.MohammadAli.data.entities.Customer;
import org.MohammadAli.models.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    ModelMapper mapper;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public void addCustomer(CustomerDTO.CREATE customerDTO) {
        customerDTO.setPassword(encoder.encode(customerDTO.getPassword()));
        Customer mapCustomer = mapper.map(customerDTO, Customer.class);
        customerDAO.save(mapCustomer);
        customerDTO.setCustomerID(mapCustomer.getCustomerID());
    }

    @Override
    public CustomerDTO findCustomerByUserName(String userName) {
        return null;
    }

    @Override
    public List<CustomerDTO.LOGIN> getAllCustomerForLogin() {

        List<Customer> all = customerDAO.findAll();
        List<CustomerDTO.LOGIN> collect = all.stream()
                                             .map(customer -> mapper.map(customer, CustomerDTO.LOGIN.class))
                                             .collect(Collectors.toList());
        return collect;
    }

    @Override
    public CustomerDTO.ADDRESS getCustomerByCustomerID(long customerId) {
        Customer one = customerDAO.findOne(customerId);
        return mapper.map(one,CustomerDTO.ADDRESS.class);
    }

    @Override
    public CustomerDTO findCustomerByUserNameAndPassWord(String username, String password) {
        return null;
    }

    @Override
    public void updateCustomer(CustomerDTO.CREATE customerDTO) {
        Customer customer = mapper.map(customerDTO , Customer.class);
        customerDAO.update(customer);
    }

    @Override
    public List<CustomerDTO.RETRIEVE> findAll() {
        List<Customer> all = customerDAO.findAll();

        List<CustomerDTO.RETRIEVE> customerList = all.stream()
                                                  .map(customer -> mapper.map(customer , CustomerDTO.RETRIEVE.class ))
                                                  .collect(Collectors.toList());
        return customerList;
    }
}
