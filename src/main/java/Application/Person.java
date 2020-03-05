package Application;

import javax.persistence.*;

//@Entity
public abstract class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id = null;

    @Column(name="name")
    private String name = null;

    private String type = null;

    public Person() {}

    public Person(String name){
        this.name = name;
    }

    public Person(String name, String type){
        this.name = name;
        this.type = type;
    }


    public Long getId(){
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

}


