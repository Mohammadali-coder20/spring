package org.MohammadAli.data;

import org.MohammadAli.data.entities.CustomerOrder;

import java.util.List;

public interface CustomerOrderDAO {

    void save(CustomerOrder customerOrderDAO);

    List<CustomerOrder> findALl();

    void delete(int id);

}
