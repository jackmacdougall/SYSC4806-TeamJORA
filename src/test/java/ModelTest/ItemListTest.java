package ModelTest;

import Model.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

public class ItemListTest {
    protected Item item1, item2;

    @Before
    public void setUp(){
        item1 = new Item("Item 1", "Description 1");
        item2 = new Item("Item 2", "Description 2");
    }

    @org.junit.Test
    public void addItemToList(){
        ItemList list = new ItemList();
        list.addItem(item1);
        assertEquals(1, list.getSize());
        list.addItem(item2);
        assertEquals(2, list.getSize());
    }

    @org.junit.Test
    public void removePersonFromList(){
        ItemList list = new ItemList();
        list.addItem(item1);
        list.addItem(item2);

        list.removeItem(item1);
        assertEquals(1, list.getSize());
        list.removeItem(item2);
        assertEquals(0, list.getSize());
    }

    @After
    public void tearDown(){
        item1 = null;
        item2 = null;
    }
}
