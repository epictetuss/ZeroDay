package netgloo.dao;

import netgloo.entity.Product;

import java.util.List;

/**
 * Created by talenthub1 on 14/05/2017.
 */
public interface IProductDao {
    void save(Product product);
    void delete(Product product);
    void update(Product product);
    List<Product> getAllProducts();
}
