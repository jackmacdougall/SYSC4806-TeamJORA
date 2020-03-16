package springboot.Model;

import javax.persistence.*;

//@Entity
public class Instructor extends Person {

   //@OneToOne(cascade = CascadeType.ALL)
    //private ItemList itemList = null;

    public Instructor() {}

    public Instructor(String name) {
        super(name, Type.INSTRUCTOR);
    }

//    public void setItemList(ItemList itemList){
//        this.itemList = itemList;
//    }
//
//    public ItemList getItemList(){
//        return this.itemList;
//    }

}
