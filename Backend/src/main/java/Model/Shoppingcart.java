package Model;

import interfaces.IOrderProduct;

import java.util.Date;
import java.util.List;

public class Shoppingcart implements IOrderProduct {
    private int id;
    private String name;
    private int quantity;
    private Date date;

    private List<Product> products;

    public Shoppingcart(){

    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    private void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Shoppingcart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean addProduct(Product product) {
        return products.add(product);
    }

    @Override
    public Product changeProduct() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
