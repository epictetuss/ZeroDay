package netgloo.dao;

import netgloo.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by talenthub1 on 14/05/2017.
 */
@Repository
public class ProductDaoImpl implements IProductDao {
    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    @Transactional
    public void save(Product product) {
        getSession().save(product);
        return;
    }

    @Transactional
    public void delete(Product product) {
        getSession().delete(product);
        return;
    }

    @Transactional
    public void update(Product product) {
        getSession().update(product);
    }


    /*public User getByEmail(String email) {
        return (User) getSession().createQuery(
                "from User where email = :email")
                .setParameter("email", email)
                .uniqueResult();
    }

    public User getById(long id) {
        return (User) getSession().load(User.class, id);
    }*/

    @Transactional
    public List<Product> getAllProducts()
    {
        return  getSession().createQuery("select p from Product p").list();
    }

}
