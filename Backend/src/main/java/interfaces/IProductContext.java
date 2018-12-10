package interfaces;

import model.product;

public interface IProductContext {
    product getProduct(int id);
    product addProduct(product product);
    product updateProduct(product product);
}
