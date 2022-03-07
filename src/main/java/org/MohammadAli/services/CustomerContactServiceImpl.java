package org.MohammadAli.services;


import org.MohammadAli.data.CustomerContactDAO;
import org.MohammadAli.data.entities.CustomerContact;
import org.MohammadAli.models.CustomerContactDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class CustomerContactServiceImpl implements CustomerContactService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    CustomerContactDAO contactDAO;

    @Override
    public void save(CustomerContactDTO.CREATE customerContactDTO) throws IOException {
        contactDAO.save(mapper.map(customerContactDTO , CustomerContact.class));

    }

    @Override
    public List<CustomerContactDTO.RETRIEVE> findAll() {
        return null;
    }

    @Override
    public void delete(CustomerContactDTO.DELETE deleteDTO) {

    }

}
