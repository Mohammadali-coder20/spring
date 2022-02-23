package org.MohammadAli.services;

import org.MohammadAli.data.AuthoritiesDAO;
import org.MohammadAli.data.entities.Authorities;
import org.MohammadAli.models.AuthoritiesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class AuthoritiesServiceImpl implements AuthoritiesService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    AuthoritiesDAO authoritiesDAO;

    @Override
    public void save(AuthoritiesDTO.CREATE authoritiesDTO) throws IOException {
        Authorities authorities = mapper.map(authoritiesDTO , Authorities.class);
        authoritiesDAO.save(authorities);
    }

    @Override
    public List<AuthoritiesDTO.RETRIEVE> findAll() {
        return null;
    }

    @Override
    public void delete(AuthoritiesDTO.DELETE deleteDTO) {

    }
}
