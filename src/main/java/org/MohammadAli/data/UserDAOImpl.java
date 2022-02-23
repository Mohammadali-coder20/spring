package org.MohammadAli.data;

import org.MohammadAli.data.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Users user) {
        Session session = getSession();
        session.save(user);
//        session.flush();
        session.close();
    }

    @Override
    public List<Users> findALl() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

}
