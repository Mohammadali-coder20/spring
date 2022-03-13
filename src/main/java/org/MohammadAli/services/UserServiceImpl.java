package org.MohammadAli.services;

import org.MohammadAli.data.UserDAO;
import org.MohammadAli.data.entities.Users;
import org.MohammadAli.models.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Autowired
    ModelMapper mapper;

    @Override
    public void save(UserDTO.CREATE userDTO) throws IOException {
        Users user = mapper.map(userDTO,Users.class);
        userDAO.save(user);
    }

    @Override
    public List<UserDTO.RETRIEVE> findAll() {
        List<Users> all = userDAO.findAll();
        return all.stream().map(users -> mapper.map(users , UserDTO.RETRIEVE.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(UserDTO.DELETE deleteDTO) {
        userDAO.deleteById(deleteDTO.getUserID());
    }


}
