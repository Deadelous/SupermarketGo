package model;

public class brand {
    private int id;
    private String name;
    private String description;

    public brand(){

    }

    public int getId() {
        return id;
    }

    private void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    private void setName(String name){
        this.name = name;
    }

    private String getDescription(){
        return description;
    }

    private void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
