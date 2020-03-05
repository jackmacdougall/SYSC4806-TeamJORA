package Application;

import javax.persistence.*;

@Entity
@Table(name="students", schema="students")
public class Student extends Person {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="studentNumber")
    private Integer studentNumber = null;

    private Boolean inGroup = false;

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
        group.addStudent(this);
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
