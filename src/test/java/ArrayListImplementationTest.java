import org.example.ArrayListImplementation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListImplementationTest {

    @Test
    public void testAdd() {
        ArrayListImplementation list = new ArrayListImplementation();
        assertEquals("test", list.add("test"));
        assertEquals(1, list.size());
    }

    @Test
    public void testAddWithIndex() {
        ArrayListImplementation list = new ArrayListImplementation();
        list.add("test1");
        list.add(0, "test2");
        assertEquals("test2", list.get(0));
        assertEquals("test1", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testSet() {
        ArrayListImplementation list = new ArrayListImplementation();
        list.add("test1");
        list.set(0, "test2");
        assertEquals("test2", list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemove() {
        ArrayListImplementation list = new ArrayListImplementation();
        list.add("test1");
        list.add("test2");
        assertEquals("test1", list.remove(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveByValue() {
        ArrayListImplementation list = new ArrayListImplementation();
        list.add("test1");
        list.add("test2");
        assertEquals("test1", list.remove("test1"));
        assertEquals(1, list.size());
    }

    @Test
    public void testContains() {
        ArrayListImplementation list = new ArrayListImplementation();
        list.add("test1");
        assertTrue(list.contains("test1"));
        assertFalse(list.contains("test2"));
    }

    @Test
    public void testIndexOf() {
        ArrayListImplementation list = new ArrayListImplementation();
        list.add("test1");
        list.add("test2");
        assertEquals(0, list.indexOf("test1"));
        assertEquals(1, list.indexOf("test2"));
        assertEquals(-1, list.indexOf("test3"));
    }

    @Test
    public void testLastIndexOf() {
        ArrayListImplementation list = new ArrayListImplementation();
        list.add("test1");
        list.add("test2");
        list.add("test1");
        assertEquals(2, list.lastIndexOf("test1"));
        assertEquals(1, list.lastIndexOf("test2"));
        assertEquals(-1, list.lastIndexOf("test3"));
    }

    @Test
    public void testGet() {
        ArrayListImplementation list = new ArrayListImplementation();
        list.add("test1");
        list.add("test2");
        assertEquals("test1", list.get(0));
        assertEquals("test2", list.get(1));
    }

    @Test
    public void testEquals() {
        ArrayListImplementation list1 = new ArrayListImplementation();
        ArrayListImplementation list2 = new ArrayListImplementation();
        list1.add("test1");
        list1.add("test2");
        list2.add("test1");
        list2.add("test2");
        assertTrue(list1.equals(list2));
        list2.set(1, "test3");
        assertFalse(list1.equals(list2));
    }

    @Test
    public void testSize() {
        ArrayListImplementation list = new ArrayListImplementation();
        list.add("test1");
        list.add("test2");
        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty() {
        ArrayListImplementation list = new ArrayListImplementation();
        assertTrue(list.isEmpty());
        list.add("test1");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testClear() {
        ArrayListImplementation list = new ArrayListImplementation();
        list.add("test1");
        list.add("test2");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        ArrayListImplementation list = new ArrayListImplementation();
        list.add("test1");
        list.add("test2");
        assertArrayEquals(new String[] {"test1", "test2"}, list.toArray());
    }
}
