package springboot.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Rubric {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;

    @ManyToOne
    private Item item;

    private Integer value;
    private String description;

//    @OneToMany
//    private List<RubricValue> rubricValues;

    public Rubric(){}

    public Rubric(Item item) {
        this.item = item;
        this.value = null;
        this.description = null;
    }

    public Rubric(Item item, Integer value, String description) {
        this.item = item;
        this.value = value;
        this.description = description;
//        this.rubricValues = new ArrayList<RubricValue>();
    }

    public Integer getValue(){
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

//    public Rubric(Item item, ArrayList<RubricValue> rubricValues) {
//        this.item = item;
//        this.rubricValues = rubricValues;
//    }

    public Item getItem(){
        return this.item;
    }

    public void addToItem(Integer id) { }
    public void addToItem(Item item) { this.item = item; }
    public void setItem(Item item){
        this.item = item;
    }

//    public void addRubricValue(RubricValue rubricValue) {
//        this.rubricValues.add(rubricValue);
//    }
//
//    public void removeRubricValue(RubricValue rubricValue) {
//        this.rubricValues.remove(rubricValue);
//    }

//    public int getSize(){
//        return this.rubricValues.size();
//    }
}
