package Model;

public class Shop {
    private int id;
    private String name;
    private int totalproducts;

    public Shop(){

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
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalproducts=" + totalproducts +
                '}';
    }
}

