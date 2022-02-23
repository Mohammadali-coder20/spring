package org.MohammadAli.services;

import org.MohammadAli.models.CustomerOrderDTO;
import org.MohammadAli.models.UserDTO;

import java.io.IOException;
import java.util.List;

public interface CustomerOrderService {

    void save(CustomerOrderDTO.CREATE customerOrderDTO) throws IOException;

    List<CustomerOrderDTO.RETRIEVE> findAll();

    void delete(CustomerOrderDTO.DELETE deleteDTO);

}
