package ModelTest;

import static org.junit.Assert.*;

import springboot.Model.Item;
import org.junit.After;
import org.junit.Before;
import springboot.Model.Rubric;

public class RubricTest {
    protected Item item1;

    @Before
    public void setUp(){

        item1 = new Item("Item 1", "Description 1");
    }

    @org.junit.Test
    public void setRubricValueAndDescription() {
        Rubric rubric = new Rubric(item1);
        rubric.setValue(123);
        rubric.setDescription("Test Description");
    }

    @org.junit.Test
    public void setItem() {
        Rubric rubric = new Rubric(item1);
        Item item2 = new Item("Item 2", "Description 1");
        rubric.setItem(item2);
        assertEquals(rubric.getItem(), item2);
    }

//    @org.junit.Test
//    public void addRubricValueToRubric(){
//        Rubric rubric = new Rubric(item1);
//        rubric.addRubricValue(rValue1);
//        assertEquals(1, rubric.getSize());
//        rubric.addRubricValue(rValue2);
//        assertEquals(2, rubric.getSize());
//        rubric.addRubricValue(rValue3);
//        assertEquals(3, rubric.getSize());
//        rubric.addRubricValue(rValue2);
//        assertEquals(3, rubric.getSize());
//    }

//    @org.junit.Test
//    public void removeRubricValueFromRubric(){
//        Rubric rubric = new Rubric(item1);
//        rubric.addRubricValue(rValue1);
//        rubric.addRubricValue(rValue2);
//        rubric.addRubricValue(rValue3);
//
//        rubric.removeRubricValue(rValue1);
//        assertEquals(2, rubric.getSize());
//        rubric.removeRubricValue(rValue2);
//        assertEquals(1, rubric.getSize());
//        rubric.removeRubricValue(rValue3);
//        assertEquals(0, rubric.getSize());
//    }


    @After
    public void tearDown(){

        item1 = null;
    }
}
