package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ItemList {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;
    private String name = null;

    @OneToMany(cascade = CascadeType.ALL)
    private ArrayList<Item> items;

    public ItemList(){
        this.items = new ArrayList<Item>();
    }

    public ItemList(String name, ArrayList<Item> items){
        this.name = name;
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

    public ArrayList<Item> getItems(){
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
