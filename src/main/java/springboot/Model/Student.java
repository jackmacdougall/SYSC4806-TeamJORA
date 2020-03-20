package springboot.Model;

import javax.persistence.*;

@Entity
public class Student extends Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;
    private String name = null;
    private String type = null;
    private Integer studentNumber = null;
    private Boolean inGroup = false;

    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;

    public Student() { this.type = "Student"; }

    public Student(String name){
        super(name, "Student");
        this.name = super.getName();
        this.type = super.getType();
    }

    public Student(String name, Integer studentNumber) {
        super(name, "Student");
        this.studentNumber = studentNumber;
    }

    public Student(String name, Integer studentNumber, Group group){
        this(name, studentNumber);
        this.group = group;
        setInGroup();
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

    public Integer getStudentNumber(){
        return this.studentNumber;
    }

    public void setStudentNumber(Integer studentNumber){
        this.studentNumber = studentNumber;
    }

    public void addToGroup(Group group){
        this.group = group;
    }
    public void setGroup(Group group){
        this.group = group;
        setInGroup();
    }

    public void leaveGroup(){
        setGroup(null);
        clearInGroup();
    }
    public Boolean isInGroup(){
        return this.inGroup;
    }

    private void setInGroup(){
        this.inGroup = true;
    }

    private void clearInGroup(){this.inGroup = false;}
}

