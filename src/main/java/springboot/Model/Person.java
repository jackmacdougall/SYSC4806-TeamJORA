package springboot.Model;

import javax.persistence.*;

@Entity
@Table(name="persons")
public abstract class Person {
    public enum Type {
        INSTRUCTOR,
        STUDENT
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;
    private String name = null;
    private Type type = null;

    public Person() {}

    public Person(String name){
        this.name = name;
        type = Type.STUDENT;
    }

    public Person(String name, Type type){
        this.name = name;
        this.type = type;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Type getType(){
        return this.type;
    }

}


