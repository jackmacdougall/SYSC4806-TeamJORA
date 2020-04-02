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

    public Person getPerson(Integer id) {return personRepository.findById(id).get();}
}
