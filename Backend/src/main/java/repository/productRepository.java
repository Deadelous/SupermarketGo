package repository;

import interfaces.IProductContext;
import model.product;

public class productRepository implements IProductContext {
   IProductContext context;

   public productRepository(IProductContext context){
       this.context = context;
   }

    @Override
    public product getProduct(int id) {
        return context.getProduct(id);
    }

    @Override
    public product addProduct(product product) {
        return context.addProduct(product);
    }

    @Override
    public product updateProduct(product product) {
        return context.updateProduct(product);
    }
}
