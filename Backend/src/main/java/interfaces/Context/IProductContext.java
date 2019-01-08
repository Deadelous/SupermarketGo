package interfaces.Context;

import Model.Product;

import java.util.List;

public interface IProductContext {
    Product getProduct(Product product);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    List<Product> getAllProducts();
}
