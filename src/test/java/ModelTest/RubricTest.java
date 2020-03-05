package ModelTest;

import Application.Item;
import Application.Rubric;
import Application.RubricValue;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

public class RubricTest {
    protected RubricValue rValue1, rValue2, rValue3;
    protected Item item1;

    @Before
    public void setUp(){
        rValue1 = new RubricValue(1, "Description 1" );
        rValue2 = new RubricValue(2, "Description 2");
        rValue3 = new RubricValue(3, "Description 3");
        item1 = new Item("Item 1", "Description 1");
    }

    @org.junit.Test
    public void addRubricValueToRubric(){
        Rubric rubric = new Rubric(item1);
        rubric.addRubricValue(rValue1);
        assertEquals(1, rubric.getSize());
        rubric.addRubricValue(rValue2);
        assertEquals(2, rubric.getSize());
        rubric.addRubricValue(rValue3);
        assertEquals(3, rubric.getSize());
        rubric.addRubricValue(rValue2);
        assertEquals(3, rubric.getSize());
    }

    @org.junit.Test
    public void removeRubricValueFromRubric(){
        Rubric rubric = new Rubric(item1);
        rubric.addRubricValue(rValue1);
        rubric.addRubricValue(rValue2);
        rubric.addRubricValue(rValue3);

        rubric.removeRubricValue(rValue1);
        assertEquals(2, rubric.getSize());
        rubric.removeRubricValue(rValue2);
        assertEquals(1, rubric.getSize());
        rubric.removeRubricValue(rValue3);
        assertEquals(0, rubric.getSize());
    }

    @org.junit.Test
    public void itemHasRubric(){
        Rubric rubric = new Rubric(item1);
        assertTrue(item1.getRubric().equals(rubric));
    }

    @After
    public void tearDown(){
        rValue1 = null;
        rValue2 = null;
        rValue3 = null;
        item1 = null;
    }
}
