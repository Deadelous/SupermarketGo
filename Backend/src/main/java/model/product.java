package model;

public class product {
    private int id;
    private String product;
    private String description;
    private double price;

    public product(){

    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    private void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
