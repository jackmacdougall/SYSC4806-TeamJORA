package springboot.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student_groups")
public class Group {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;
    private String name = null;

    public Group(){}

    public Group(String name) {
        this.name = name;
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

}
