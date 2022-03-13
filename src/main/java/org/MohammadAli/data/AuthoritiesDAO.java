package org.MohammadAli.data;

import org.MohammadAli.data.entities.Authorities;
import org.MohammadAli.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthoritiesDAO extends JpaRepository<Authorities , Long> {



}
