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
    private String type = null;
    private Boolean isUser = null;

    public Person() { this.isUser = false; }

    public Person(String name){
        this.name = name;
        this.isUser = false;
        type = Type.STUDENT.toString();
    }

    public Person(String name, String type) {
        this.name = name;
        if (type.equalsIgnoreCase("instructor")) {
            this.type = Type.INSTRUCTOR.toString();
        } else {
            this.type = Type.STUDENT.toString();
        }
        this.isUser = false;
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

    public String getType(){
        return this.type;
    }

    public Boolean isUser(){
        return this.isUser;
    }

    public void setAsUser(){ this.isUser = true; }

    public void stopBeingUser() { this.isUser = false; }

}
