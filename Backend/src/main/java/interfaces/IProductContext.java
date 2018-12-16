package interfaces;

import Model.Product;

public interface IProductContext {
    Product getProduct(int id);
    Product addProduct(Product product);
    Product updateProduct(Product product);
}
