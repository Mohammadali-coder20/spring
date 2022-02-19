package org.MohammadAli.services;

import org.MohammadAli.data.CustomerDAO;
import org.MohammadAli.data.entities.Customer;
import org.MohammadAli.models.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    ModelMapper mapper;


    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer mapCustomer = mapper.map(customerDTO, Customer.class);
        customerDAO.save(mapCustomer);
    }

    @Override
    public CustomerDTO findCustomerByUserName(String userName) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return null;
    }

    @Override
    public CustomerDTO getCustomerByCustomerID(long customerId) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerByUserNameAndPassWord(String username, String password) {
        return null;
    }
}
