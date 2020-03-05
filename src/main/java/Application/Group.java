package Application;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name="Group", schema="student_groups")
public class Group {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;
    private String name = null;
    private Integer maxSize = -1;

    //@OneToMany(targetEntity=Student.class, fetch=FetchType.EAGER)
    private List<Student> students;

    public Group() {
        this.students = new ArrayList<>();
    }

    public Group(String name) {
        this.name = name;
        this.maxSize = -1;
        this.students = new ArrayList<>();
    }

    public Group(String name, Integer maxSize) {
        this.name = name;
        this.maxSize = maxSize;
        this.students = new ArrayList<>();
    }

    public Group(String name, List<Student> students, Integer maxSize){
        this.name = name;
        this.students = students;
        this.maxSize = maxSize;
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

    public List<Student> getStudents(){
        return this.students;
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }

    public Integer getMaxSize(){
        return this.maxSize;
    }

    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }

    public void addStudent(Student student) {
        if (maxSize == -1 || this.getSize() < maxSize) {
            if (!student.isInGroup()){
                this.students.add(student);
                student.setGroup(this);
            }
        }
    }

    public void removeStudent(Student student){
        if(students.contains(student)) {
            this.students.remove(student);

            student.leaveGroup();
        }
    }

    public int getSize(){
        return this.students.size();
    }

}
