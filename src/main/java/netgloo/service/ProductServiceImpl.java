package netgloo.service;

import netgloo.dao.ProductDaoImpl;
import netgloo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by talenthub1 on 14/05/2017.
 */
@Component
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDaoImpl dao;

    @Override
    public void save(Product product) {
     dao.save(product);
    }

    @Override
    public void delete(Product product) {
     dao.delete(product);
    }

    @Override
    public void update(Product product) {
     dao.update(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }
}
