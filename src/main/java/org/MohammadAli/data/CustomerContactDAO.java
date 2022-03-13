package org.MohammadAli.data;

import org.MohammadAli.data.entities.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerContactDAO  extends JpaRepository<CustomerContact , Long> {


}
