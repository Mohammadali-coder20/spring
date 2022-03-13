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
import java.util.stream.Collectors;

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
        List<CustomerContact> aLl = contactDAO.findAll();
        return aLl.stream().map(contactDAO -> mapper.map(contactDAO , CustomerContactDTO.RETRIEVE.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long contactID) {
        contactDAO.deleteById(contactID);
    }

}
