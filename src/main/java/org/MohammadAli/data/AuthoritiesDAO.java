package org.MohammadAli.data;

import org.MohammadAli.data.entities.Authorities;
import org.MohammadAli.data.entities.Product;

import java.util.List;

public interface AuthoritiesDAO {

    void save(Authorities authorities);

    List<Authorities> findALl();

    void delete(int id);
}
