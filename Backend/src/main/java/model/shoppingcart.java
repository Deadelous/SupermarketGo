package model;

import java.util.Date;

public class shoppingcart {
    private int id;
    private String name;
    private int quantity;
    private Date date;

    public shoppingcart(){

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
        return "shoppingcart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
