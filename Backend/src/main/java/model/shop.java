package model;

public class shop {
    private int id;
    private String name;
    private int totalproducts;

    public shop(){

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

    public int getTotalproducts() {
        return totalproducts;
    }

    private void setTotalproducts(int totalproducts) {
        this.totalproducts = totalproducts;
    }

    @Override
    public String toString() {
        return "shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalproducts=" + totalproducts +
                '}';
    }
}

