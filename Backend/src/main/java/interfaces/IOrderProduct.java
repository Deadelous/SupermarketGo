package interfaces;

import Model.Product;

public interface IOrderProduct {
    boolean addProduct(Product product);
    Product changeProduct();
    void deleteProduct();
}
