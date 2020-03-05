package ModelTest;

import static org.junit.Assert.*;

import springboot.Model.Group;
import org.junit.After;
import org.junit.Before;
import springboot.Model.Student;

public class GroupTest {
    protected Student student1, student2, student3;

    @Before
    public void setUp(){
        student1 = new Student("John Smith", 1);
        student2 = new Student("Bob Jones", 2);
        student3 = new Student("Joe Brown", 3);
    }

    @org.junit.Test
    public void addStudentToGroup(){
        Group group = new Group("Group", 2);
        group.addStudent(student1);
        assertEquals(1, group.getSize());
        group.addStudent(student1);
        assertEquals(1, group.getSize());
        group.addStudent(student2);
        assertEquals(2, group.getSize());
        group.addStudent(student3);
        assertEquals(2, group.getSize());
    }

    @org.junit.Test
    public void removeStudentFromList(){
        Group group = new Group("Group");
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);

        group.removeStudent(student1);
        assertEquals(2, group.getSize());
        group.removeStudent(student2);
        assertEquals(1, group.getSize());
        group.removeStudent(student3);
        assertEquals(0, group.getSize());
    }

    @org.junit.Test
    public void checkStudentInGroup(){
        Group group = new Group("Group");
        assertFalse(student1.isInGroup());
        group.addStudent(student1);
        assertTrue(student1.isInGroup());
        group.removeStudent(student1);
        assertFalse(student1.isInGroup());
    }

    @After
    public void tearDown(){
        student1 = null;
        student2 = null;
        student3 = null;
    }
}
