package springboot.Model;

import javax.persistence.*;

@Entity
public class Student extends Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;
    private Integer studentNumber = null;
    private Boolean inGroup = false;

    @ManyToOne
    private Group group;

    public Student() {}
    public Student(String name, Integer studentNumber) {
        super(name, "student");
        this.studentNumber = studentNumber;
    }

    public Student(String name, Integer studentNumber, Group group){
        this(name, studentNumber);
        this.group = group;
        setInGroup();
    }

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
