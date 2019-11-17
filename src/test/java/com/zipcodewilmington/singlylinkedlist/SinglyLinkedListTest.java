package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
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
        testList.add("5");
    }

    @After
    public void tearDown() throws Exception{
        testList.clear();
    }

    @Test
    public void testNullaryConstructor(){
        Assert.assertEquals(0, nullList.size());
        Assert.assertNull(nullList.get(0));
    }

    @Test
    public void testClear(){
        Assert.assertTrue(testList.clear());
        Assert.assertEquals(0, testList.size());
        Assert.assertNull(testList.get(0));
    }

    @Test
    public void testAdd(){
        testList.add("6");
        Assert.assertEquals("6", testList.get(5));
        Assert.assertEquals(6, testList.size());
    }

    @Test
    public void testAdd2(){
        testList.add("Q", 2);
        Assert.assertEquals("Q", testList.get(2));
        Assert.assertEquals("3", testList.get(3));
        Assert.assertEquals(6, testList.size());
    }

    @Test
    // removes from middle of list
    public void testRemove(){
        Assert.assertTrue(testList.remove(2));
        Assert.assertEquals("4", testList.get(2));
        Assert.assertEquals(4, testList.size());
    }

    @Test
    // removes the first element in the list
    public void testRemove2(){
        Assert.assertTrue(testList.remove(0));
        Assert.assertEquals("2", testList.get(0));
        Assert.assertEquals(4, testList.size());
    }

    @Test
    public void testContains(){
        Assert.assertTrue(testList.contains("1"));
        Assert.assertTrue(testList.contains("5"));
        Assert.assertFalse(testList.contains("Q"));
    }

    @Test
    public void testFind(){
        Assert.assertEquals(0, testList.find("1"));
        Assert.assertEquals(3, testList.find("4"));
        Assert.assertEquals(-1, testList.find("Horse"));
    }

    @Test
    public void testSize(){
        //getSize is returning the size of the most recently constructed list, not necessarily the list in question
        // need to figure out why listCount is operating independently
        // SOLVED - I had listCount operating as a static variable
        Assert.assertEquals(5, testList.size());
    }

    @Test
    // test get when object exists
    public void testGet(){
        Assert.assertEquals("3", testList.get(2));
    }

    @Test
    // test get when object does not exist
    public void testGet2(){
        Assert.assertNull(testList.get(8));
    }

    @Test
    // test get when passing an invalid index
    public void testGet3(){
        Assert.assertNull(testList.get(-1));
    }

    @Test
    public void testToString(){
        String expected = "[1][2][3][4][5]";
        Assert.assertEquals(expected, testList.toString());
    }

    @Test
    // test toString with a null list
    public void testToString2(){
        String expected = "list has not been instantiated";
        Assert.assertEquals(expected,nullList.toString());
    }

    @Test
    // test toString with an empty list
    public void testToString3(){
        testList.clear();
        String expected = "list is empty";
        Assert.assertEquals(expected,testList.toString());
    }

    @Test
    // test copy an existing list
    public void testCopy(){
        SinglyLinkedList copyOfTestList = new SinglyLinkedList();
        copyOfTestList = testList.copy();
        Assert.assertEquals(testList.toString(),copyOfTestList.toString());
    }

    @Test
    // test copy an empty list
    public void testCopy2(){
        SinglyLinkedList copyOfTestList = new SinglyLinkedList();
        testList.clear();
        copyOfTestList = testList.copy();
        Assert.assertEquals(testList.toString(),copyOfTestList.toString());
    }

    @Test
    // test copy a null list
    public void testCopy3(){
        SinglyLinkedList copyOfTestList = new SinglyLinkedList();
        copyOfTestList = nullList.copy();
        Assert.assertEquals(nullList.toString(),copyOfTestList.toString());
    }

    @Test
    // sort a list of E's
    public void testSort(){
        testList.add("Q");
        testList.add("8");
        Assert.assertEquals("[1][2][3][4][5][8][Q]", testList.sort().toString());
    }

}
