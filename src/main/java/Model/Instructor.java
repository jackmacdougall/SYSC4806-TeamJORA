package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Instructor extends Person {

    @OneToOne(cascade = CascadeType.ALL)
    private ItemList itemList = null;

    public Instructor() {}

    public Instructor(String name) {
        super(name, "instructor");
    }

    public void setItemList(ItemList itemList){
        this.itemList = itemList;
    }

    public ItemList getItemList(){
        return this.itemList;
    }

}
