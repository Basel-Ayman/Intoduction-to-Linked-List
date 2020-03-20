package eg.edu.alexu.csd.datastructure.linkedList.cs18_cs52;

import static org.junit.Assert.*;
import org.junit.Test;

public class DLinkedListTest {

    @Test
    public void Test() {
        DLinkedList dLinkedList = new DLinkedList();
        //Adding Nodes
        dLinkedList.add("1");
        dLinkedList.add("2");
        dLinkedList.add(1,"3");
        dLinkedList.add(2,"4");
        //Test_add & get
        assertEquals(dLinkedList.get(0),"1");
        assertEquals(dLinkedList.get(1),"3");
        assertEquals(dLinkedList.get(2),"4");
        assertEquals(dLinkedList.get(3),"2");
        //Set Nodes
        dLinkedList.set(2,"Basel");
        //Test_set & get
        assertEquals(dLinkedList.get(2), "Basel");
        //Removing Nodes
        dLinkedList.remove(1);
        //Test_size & deletedNodes
        assertEquals(dLinkedList.size(), 3);
        assertEquals(dLinkedList.get(1), "Basel");
        //Test_contains
        assertFalse(dLinkedList.contains("Amr"));
        assertFalse(dLinkedList.contains("8"));
        assertTrue(dLinkedList.contains("Basel"));
        assertFalse(dLinkedList.contains("2000"));
        //Clearing
        dLinkedList.clear();
        //Test_empty
        assertTrue(dLinkedList.isEmpty());
    }

    @Test
    //Test_sublist
    public void sublistTest() {

        DLinkedList dLinkedList = new DLinkedList();
        DLinkedList sub = new DLinkedList();
        DLinkedList sub1;
        int i;
        for (i=0;i<15;i++) {
            dLinkedList.add(i);
        }
        for(i=6;i<12;i++) {
            sub.add(i);
        }
        sub1 = (DLinkedList) dLinkedList.sublist(6,11);
        for (i=0;i<sub1.size();i++) {
            assertEquals(sub1.get(i),sub.get(i));
        }
        assertFalse(sub.contains(18));
    }
}