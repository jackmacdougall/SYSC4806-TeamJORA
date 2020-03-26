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

    @ManyToMany(cascade = CascadeType.ALL)
    private Rubric rubric;

    public Result(){}

    public Result(Student student, Rubric rubric){
        this.student = student;
        this.rubric = rubric;
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

    public Rubric getRubric() { return this.rubric; }

    public void setRubric(Rubric rubric) { this.rubric = rubric; }

}
