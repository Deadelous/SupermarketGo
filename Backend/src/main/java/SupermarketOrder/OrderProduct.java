package SupermarketOrder;

import Model.Product;
import interfaces.IOrderProduct;

public class OrderProduct implements IOrderProduct {


    @Override
    public boolean addProduct(Product Product) {
      return true;

    }

    @Override
    public Product changeProduct() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
