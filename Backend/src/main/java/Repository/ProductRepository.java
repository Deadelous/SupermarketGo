package Repository;

import interfaces.Context.IProductContext;
import Model.Product;

import java.util.List;

public class ProductRepository implements IProductContext {
   IProductContext context;

    public ProductRepository() {
    }

    public ProductRepository(IProductContext context){
       this.context = context;
   }

    @Override
    public Product getProduct(Product product) {
        return context.getProduct(product);
    }

    @Override
    public Product addProduct(Product product) {
        return context.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return context.updateProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return context.getAllProducts();
    }

}
