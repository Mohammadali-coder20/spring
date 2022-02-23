package org.MohammadAli.services;


import org.MohammadAli.models.CustomerContactDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CustomerContactServiceImpl implements CustomerContactService{

    @Override
    public void save(CustomerContactDTO.CREATE customerContactDTO) throws IOException {

    }

    @Override
    public List<CustomerContactDTO.RETRIEVE> findAll() {
        return null;
    }

    @Override
    public void delete(CustomerContactDTO.DELETE deleteDTO) {

    }

}
