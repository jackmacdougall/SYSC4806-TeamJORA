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

    public Instructor() {}

    public Instructor(String name) {
        super(name, "Instructor");
        this.name = super.getName();
        this.type = super.getType();
    }

    public void setId(Integer id) {
        System.out.println("Set Instructor Id");
        this.id = id;
    }

    public void setName(String name) {
        System.out.println("Set Instructor Name");
        System.out.println(type);
        this.name = name;
    }

    public void setType(String type) {
        System.out.println("Set Instructor Type");
        this.type = "Idiot";
    }

    public Integer getId() { return this.id; }

    public String getName() { return this.name; }

    public String getType() { return this.type; }
}
