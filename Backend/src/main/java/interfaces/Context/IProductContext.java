package interfaces;

import Model.Product;

public interface IProductContext {
    Product getProduct(Product product);
    Product addProduct(Product product);
    Product updateProduct(Product product);
}
