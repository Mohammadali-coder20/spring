package org.MohammadAli.services;


import org.MohammadAli.models.CustomerOrderDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Override
    public void save(CustomerOrderDTO.CREATE customerOrderDTO) throws IOException {

    }

    @Override
    public List<CustomerOrderDTO.RETRIEVE> findAll() {
        return null;
    }

    @Override
    public void delete(CustomerOrderDTO.DELETE deleteDTO) {

    }
}
