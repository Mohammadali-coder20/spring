package org.MohammadAli.data;

import java.util.List;

public interface CustomerOrderDAO {

    void save(CustomerOrderDAO customerOrderDAO);

    List<CustomerOrderDAO> findALl();

    void delete(int id);

}
