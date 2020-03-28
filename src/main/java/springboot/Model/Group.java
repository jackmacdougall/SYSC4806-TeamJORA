package springboot.Model;

import org.hibernate.exception.internal.CacheSQLExceptionConversionDelegate;

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

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students = null;

    public Group(){
        this.students = new ArrayList<Student>();
    }

    public Group(String name) {
        this.name = name;
        this.students = new ArrayList<Student>();
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

    public void addStudent(Student student) {
        this.students.add(student);
    }

}
