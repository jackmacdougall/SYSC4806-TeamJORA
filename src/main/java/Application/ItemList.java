package Application;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ItemList {

    private Integer id = null;
    private String name = null;

    private Instructor instructor = null;

    private List<Item> items;

    public ItemList(){
        this.items = new ArrayList<>();
    }

    public ItemList(String name, Instructor instructor){
        this.name = name;
        this.instructor = instructor;
        this.instructor.setItemList(this);
        this.items = new ArrayList<>();
    }

    public ItemList(String name, Instructor instructor, List<Item> items){
        this.name = name;
        this.instructor = instructor;
        this.items = items;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Item> getItems(){
        return this.items;
    }

    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public int getSize(){
        return this.items.size();
    }
}
