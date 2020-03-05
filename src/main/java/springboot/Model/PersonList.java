package springboot.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class PersonList {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id = null;
    private String name = null;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Person> personList;

    public PersonList(){
        this.personList = new ArrayList<Person>();
    }

    public PersonList(String name, ArrayList<Person> personList){
        this.name = name;
        this.personList = personList;
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

    public List<Person> getPersonList(){
        return this.personList;
    }

    public void setPersonList(ArrayList<Person> personList){
        this.personList = personList;
    }

    public void addPerson(Person person){
        this.personList.add(person);
    }

    public void removePerson(Person person){
        this.personList.remove(person);
    }

    public int getSize(){
        return this.personList.size();
    }
}
