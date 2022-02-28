package org.MohammadAli.data;

import org.MohammadAli.data.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Product product) {
        Session session = getSession();
        session.save(product);
        session.close();
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
    @Transactional
    public void delete(int id) {
        Product p = entityManager.find(Product.class,id);
        entityManager.remove(p);
        entityManager.flush();
    }

    @Override
//    @Transactional
    public byte[] retrieveProductImgByID(Long id) {
//        Product product = entityManager.find(Product.class,id);
//        Object[] img = result.stream().toArray(new IntFunc() {
//            @Overridetion
//            public Object apply(int value) {
//                return new byte[value];
//            }
//        });
        Session session = getSession();
        Query result = session.createQuery("select img from Product where productID = :pid").setParameter("pid",id);
        byte[] img  = (byte[]) result.list().get(0);
        session.close();
        return img;
    }

    @Override
    public Product findProductBYID(long productID) {
        Product product = entityManager.find(Product.class, productID);
        return product;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
