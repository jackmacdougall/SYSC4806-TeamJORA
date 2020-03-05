package ModelTest;

import Application.PersonList;
import Application.Person;
import Application.Student;
import Application.Instructor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

public class PersonListTest {
    protected Person student1, student2, instructor1;

    @Before
    public void setUp(){
        student1 = new Student("John Smith", 1);
        student2 = new Student("Bob Jones", 2);
        instructor1 = new Instructor("Joe Brown");
    }

    @org.junit.Test
    public void addPersonToList(){
        PersonList list = new PersonList();
        list.addPerson(student1);
        assertEquals(1, list.getSize());
        list.addPerson(instructor1);
        assertEquals(2, list.getSize());
        list.addPerson(student1);
        assertEquals(2, list.getSize());
    }

    @org.junit.Test
    public void removePersonFromList(){
        PersonList list = new PersonList();
        list.addPerson(student1);
        list.addPerson(student2);
        list.addPerson(instructor1);

        list.removePerson(student2);
        assertEquals(2, list.getSize());
        list.removePerson(student1);
        assertEquals(1, list.getSize());
        list.removePerson(instructor1);
        assertEquals(0, list.getSize());
    }

    @After
    public void tearDown(){
        student1 = null;
        student2 = null;
        instructor1 = null;
    }
}
