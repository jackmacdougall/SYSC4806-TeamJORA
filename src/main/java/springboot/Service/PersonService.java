package springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Model.Person;
import springboot.Model.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public void addPerson(Person person){
        personRepository.save(person);
    }

    public Person getPerson(String name) {return personRepository.findByName(name);}

    public Person getPersonById(Integer id) { return personRepository.findById(id).get();}

    public Person getUser() { return personRepository.findByIsUser(true);}

    public void clearUser() {
        if(personRepository.findByIsUser(true) != null) {
            Person user = personRepository.findByIsUser(true);
            user.stopBeingUser();
        }
    }

    public void setUser(Integer id){
        clearUser();
        Person newUser = personRepository.findById(id).get();
        newUser.setAsUser();
    }
}


