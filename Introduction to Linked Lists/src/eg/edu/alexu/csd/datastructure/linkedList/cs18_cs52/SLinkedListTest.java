package eg.edu.alexu.csd.datastructure.linkedList.cs18_cs52;

import static org.junit.Assert.*;
import org.junit.Test;

public class SLinkedListTest {

    @Test
    public void Test() {
        SLinkedList singleTesting = new SLinkedList();
        //Adding nodes to the end of the new empty list  using integers
        singleTesting.add(1);
        singleTesting.add(2);
        //Adding nodes at a particular index of the new list
        singleTesting.add(1,3);
        singleTesting.add(2,4);
        //testing the get() method
        assertEquals(singleTesting.get(0),1);
        assertEquals(singleTesting.get(1),3);
        assertEquals(singleTesting.get(2),4);
        assertEquals(singleTesting.get(3),2);
        //testing the set() method
        singleTesting.set(2,9);
        assertEquals(singleTesting.get(2),9);
        //testing the size() method
        assertEquals(singleTesting.size(),4);
        //testing the remove() method
        singleTesting.remove(1);
        assertEquals(singleTesting.get(2),2);
        assertEquals(singleTesting.size(),3);
        //testing the contains() method
        assertTrue(singleTesting.contains(1));
        assertFalse(singleTesting.contains(4));
        assertTrue(singleTesting.contains(9));
        assertFalse(singleTesting.contains(19));
        //testing isEmpty() method
        assertFalse(singleTesting.isEmpty());
        assertFalse(singleTesting.contains(20));
        //testing clear() method
        singleTesting.clear();
        assertTrue(singleTesting.isEmpty());
        //testing the add method using strings
        singleTesting.add("amr");
        singleTesting.add("basel");
        singleTesting.add(1,"ahmed");
        singleTesting.add(2,"ali");
        assertEquals(singleTesting.get(0),"amr");
        assertEquals(singleTesting.get(1),"ahmed");
        assertEquals(singleTesting.get(2),"ali");
        assertEquals(singleTesting.get(3),"basel");
    }

    @Test
    public void sublistTest() {
        SLinkedList testingList = new SLinkedList();
        for (int i=0;i<10;i++) {
            testingList.add(i);
        }
        SLinkedList testingSubList = (SLinkedList) testingList.sublist(2,6);
        assertEquals(testingSubList.size(),5);
        assertFalse(testingSubList.contains(15));
        assertEquals(testingSubList.get(2),4);
    }
}