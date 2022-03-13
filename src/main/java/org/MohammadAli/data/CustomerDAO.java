package org.MohammadAli.data;

import org.MohammadAli.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer , Long> {

    Customer getCustomerByUserName(String userName);

}
