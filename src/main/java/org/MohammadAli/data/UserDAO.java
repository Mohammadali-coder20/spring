package org.MohammadAli.data;


import org.MohammadAli.data.entities.Users;

import java.util.List;

public interface UserDAO {
    void save(Users user);

    List<Users> findALl();

    void delete(int id);
}
