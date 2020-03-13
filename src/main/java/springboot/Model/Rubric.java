package springboot.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//@Entity
public class Rubric {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;

    @OneToOne
    private Item item = null;

    @OneToMany
    private List<RubricValue> rubricValues;

    public Rubric(){
        this.rubricValues = new ArrayList<RubricValue>();
    }

    public Rubric(Item item) {
        this.item = item;
        this.rubricValues = new ArrayList<RubricValue>();
    }

    public Rubric(Item item, ArrayList<RubricValue> rubricValues) {
        this.item = item;
        this.rubricValues = rubricValues;
    }

    public Item getItem(){
        return this.item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public void addRubricValue(RubricValue rubricValue) {
        this.rubricValues.add(rubricValue);
    }

    public void removeRubricValue(RubricValue rubricValue) {
        this.rubricValues.remove(rubricValue);
    }

    public int getSize(){
        return this.rubricValues.size();
    }
}
