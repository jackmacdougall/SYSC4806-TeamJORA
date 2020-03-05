package Application;

import java.util.ArrayList;
import java.util.List;


public class PersonList {

    private Integer id = null;
    private String name = null;

    private List<Person> personList;

    public PersonList(){
        this.personList = new ArrayList<>();
    }

    public PersonList(String name, List<Person> personList){
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

    public void setPersonList(List<Person> personList){
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
