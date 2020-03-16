package springboot.Model;

import javax.persistence.*;

@Entity
@Table(name = "instructors")
public class Instructor extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = null;
    private String name = null;

    public Instructor() {}

    public Instructor(String name) {
        super(name, Type.INSTRUCTOR);
    }

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public Integer getId() { return this.id; }
    public String getName() { return this.name; }
}
