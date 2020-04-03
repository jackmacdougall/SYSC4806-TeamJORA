package springboot.Model;

import springboot.Service.ResultService;

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
    @JoinColumn
    private Group group;

    public Student() {
        this.type = "Student";
        this.inGroup = false;
    }

    public Student(String name){
        super(name, "Student");
        this.name = super.getName();
        this.type = super.getType();
        this.inGroup = false;
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

    public void joinGroup(Group group){
        this.group = group;
        group.addStudent(this);
        setInGroup();
    }

    public void setGroup(Group group){
        this.group = group;
        setInGroup();
    }

    public Boolean isInGroup(){
        return this.inGroup;
    }

    private void setInGroup(){
        this.inGroup = true;
    }

    private void clearInGroup(){this.inGroup = false;}

    public Integer getAverage(Item item, ResultService resultService) {
        Iterable<Result> results = resultService.getAllResultsByStudent(this);
        Integer sum = 0;
        Integer count = 0;
        for (Result result : results) {
            Rubric rubric = result.getRubric();
            if(rubric.getItem().getId() == item.getId()) {
                count++;
                if (rubric.getValue() != null) {
                    sum += rubric.getValue();
                }
            }
        }
        if (count == 0) { return 0; }
        return (sum/count);
    }
}

