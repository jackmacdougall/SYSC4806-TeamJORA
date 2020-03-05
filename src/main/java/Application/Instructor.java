package Application;

public class Instructor extends Person {

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
