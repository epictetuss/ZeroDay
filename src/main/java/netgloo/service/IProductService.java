package netgloo.service;

import netgloo.entity.Product;

import java.util.List;

/**
 * Created by talenthub1 on 14/05/2017.
 */
public interface IProductService {
    void save(Product product);
    void delete(Product product);
    void update(Product product);
    List<Product> getAllProducts();
}
