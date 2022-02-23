package org.MohammadAli.data;

import org.MohammadAli.data.entities.Authorities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Authorities authorities) {
        entityManager.persist(authorities);
        entityManager.flush();
    }

    @Override
    public List<Authorities> findALl() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    public Session getSession(){
        return sessionFactory.openSession();
    }


}
