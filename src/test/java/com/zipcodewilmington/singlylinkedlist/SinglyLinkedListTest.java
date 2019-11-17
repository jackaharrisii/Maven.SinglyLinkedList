package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    public static SinglyLinkedList testList;
    public static SinglyLinkedList nullList;

    @Before
    public void setUp() throws Exception {
        nullList = new SinglyLinkedList();
        testList = new SinglyLinkedList();
        testList.add("1");
        testList.add("2");
        testList.add("3");
        testList.add("4");
    }

    @Test
    public void testNullaryConstructor(){
        Assert.assertEquals(0, nullList.size());
        // NOTE THAT THERE ARE NO EXISTENT ELEMENTS IN THIS LIST
        // GET(INDEX 0) WOULD DRAW A NULL POINTER EXCEPTION

        // I think this is failing because it's confusing the two lists somehow
    }

    @Test
    public void testGetSize(){
        Assert.assertEquals(4, testList.size());
    }

    @Test
    public void testAdd(){
        testList.add("5");
        Assert.assertEquals("1", testList.get(0));
        Assert.assertEquals("2", testList.get(1));
        Assert.assertEquals("3", testList.get(2));
        Assert.assertEquals("4", testList.get(3));
        Assert.assertEquals("5", testList.get(4));
        Assert.assertEquals(5, testList.size());
    }

    @Test
    public void testAdd2(){
        testList.add("Q", 2);
        Assert.assertEquals("Q", testList.get(2));
        Assert.assertEquals("3", testList.get(3));
        Assert.assertEquals(6, testList.size());
    }

    @Test
    public void testRemove(){
        testList.remove(0);
        Assert.assertEquals("2", testList.get(0));
        Assert.assertEquals(5, testList.size());
        // I think this removed the last item in the list instead of the first - look at the toString()
    }

    @Test
    public void testToString(){
        String expected = "[1][2][3][4][5]";
        Assert.assertEquals(expected, testList.toString());
    }

}
