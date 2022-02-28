package org.MohammadAli.services;


import org.MohammadAli.data.CustomerOrderDAO;
import org.MohammadAli.data.entities.CustomerOrder;
import org.MohammadAli.models.CustomerOrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    CustomerOrderDAO customerOrderDAO;

    @Autowired
    ModelMapper mapper;

    @Override
    public void save(CustomerOrderDTO.CREATE customerOrderDTO) throws IOException {

    }

    @Override
    public List<CustomerOrderDTO.RETRIEVE> findAll() {
        List<CustomerOrder> orders = customerOrderDAO.findALl();
        return orders.stream()
                     .map(customerOrder -> mapper.map(customerOrder , CustomerOrderDTO.RETRIEVE.class))
                     .collect(Collectors.toList());
    }

    @Override
    public void delete(CustomerOrderDTO.DELETE deleteDTO) {

    }
}
