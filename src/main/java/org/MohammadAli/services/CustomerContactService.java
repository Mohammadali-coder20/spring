package org.MohammadAli.services;

import org.MohammadAli.models.CustomerContactDTO;

import java.io.IOException;
import java.util.List;

public interface CustomerContactService {

    void save(CustomerContactDTO.CREATE customerContactDTO) throws IOException;

    List<CustomerContactDTO.RETRIEVE> findAll();

    void delete(CustomerContactDTO.DELETE deleteDTO);

}
