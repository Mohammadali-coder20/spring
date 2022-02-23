package org.MohammadAli.data;

import java.util.List;

public interface CustomerContactDAO {

    void save(CustomerContactDAO customerContactDAO);

    List<CustomerContactDAO> findALl();

    void delete(int id);

}
