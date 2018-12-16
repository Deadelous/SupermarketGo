package Model;

public class Department {
    private int id;
    private String name;
    private String area;
    private String description;

    public Department(){

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

    public String getArea() {
        return area;
    }

    private void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


