package springboot.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;
    private String name = null;
    private String description = null;

//    @OneToMany
//    private List<Rubric> rubrics = null;

    public Item() {}

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

//    public List<Rubric> getRubric(){
//        return this.rubrics;
//    }
//
//    public void addRubric(Rubric rubric){
//        this.rubrics.add(rubric);
//    }
}
