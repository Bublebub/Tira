/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalc.logic.dataStructure;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elmeri
 */
public class MyArrayElementTest {
    
    public MyArrayElementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of printID method, of class MyArrayElement.
     */
    @Test
    public void testPrintID() {
        System.out.println("printID");
        MyArrayElement instance = new MyArrayElement();
        instance.printID();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setID method, of class MyArrayElement.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int id = 0;
        MyArrayElement instance = new MyArrayElement();
        instance.setID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class MyArrayElement.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int newValue = 0;
        MyArrayElement instance = new MyArrayElement();
        instance.setValue(newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNext method, of class MyArrayElement.
     */
    @Test
    public void testSetNext() {
        System.out.println("setNext");
        MyArrayElement next = null;
        MyArrayElement instance = new MyArrayElement();
        instance.setNext(next);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class MyArrayElement.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        MyArrayElement instance = new MyArrayElement();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class MyArrayElement.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        MyArrayElement instance = new MyArrayElement();
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNext method, of class MyArrayElement.
     */
    @Test
    public void testGetNext() {
        System.out.println("getNext");
        MyArrayElement instance = new MyArrayElement();
        MyArrayElement expResult = null;
        MyArrayElement result = instance.getNext();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
