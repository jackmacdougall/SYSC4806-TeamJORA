package springboot.Model;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Instructor extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = null;
    private String name = null;
    private String type = null;

    public Instructor() {
        this.type = "Instructor";
    }

    public Instructor(String name) {
        super(name, "Instructor");
        this.name = super.getName();
        this.type = super.getType();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = "Instructor";
    }

    public Integer getId() { return this.id; }

    public String getName() { return this.name; }

    public String getType() { return this.type; }
}
