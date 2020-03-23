package springboot.Model;

import javax.persistence.*;

@Entity
@Table(name="student_result")
public class Result {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    private Integer value;

    public Result(){}

    public Result(Student student, Integer value){
        this.student = student;
        this.value = value;
    }

    public Integer getId() {
        return this.id;
    }

    public Student getStudent(){
        return this.student;
    }

    public void setStudent(Student student){
        this.student = student;
    }

    public Integer getValue() { return this.value; }

    public void setValue(Integer value) { this.value = value; }

}
