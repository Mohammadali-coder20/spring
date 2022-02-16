package org.MohammadAli.data;

import org.MohammadAli.data.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Product product) {
        Session session = getSession();
        session.save(product);
    }

    @Override
    public List<Product> findALl() {
        try(Session session = getSession()) {
            Query from_product = session.createQuery("from Product");
            List<Product> list = from_product.list();
            return list;
        }
    }

    @Override
    public void delete(int id) {
        Session session = getSession();
//        Product p = new Product();
//        p.setId(id);
        Product p = session.get(Product.class,id);
        session.remove(p);
        session.close();
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
