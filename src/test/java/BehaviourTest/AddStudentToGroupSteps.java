package BehaviourTest;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import springboot.Model.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddStudentToGroupSteps {

    private Student student;
    private Group group;

    @Given("a student that is not yet in a group")
    public void aStudent(){
        student = new Student("student1");
    }

    @When("the student joins a group")
    public void theStudentJoinsAGroup(){
        group = new Group("group1");
        student.joinGroup(group);
    }

    @Then("the student inGroup status should be true")
    public void theInGroupStatusShouldBeTrue(){
       assertTrue(student.isInGroup());
    }
}
