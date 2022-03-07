package org.MohammadAli.data;

import org.MohammadAli.data.entities.CustomerContact;

import java.util.List;

public interface CustomerContactDAO {

    void save(CustomerContact customerContact);

    List<CustomerContact> findALl();

    void delete(int id);

}
