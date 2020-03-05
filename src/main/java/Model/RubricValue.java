package Model;

import javax.persistence.*;

//@Entity
public class RubricValue {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;
    private Integer value = null;
    private String description = null;

    public RubricValue(){}

    public RubricValue(Integer value, String description) {
        this.value = value;
        this.description = description;
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

}
