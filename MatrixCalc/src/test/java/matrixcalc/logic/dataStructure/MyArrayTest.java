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
public class MyArrayTest {
    
    public MyArrayTest() {
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
     * Test of createMyArray method, of class MyArray.
     */
    @Test
    public void testCreateMyArray() {
        System.out.println("createMyArray");
        MyArray instance = null;
        instance.createMyArray();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMyArray method, of class MyArray.
     */
    @Test
    public void testPrintMyArray() {
        System.out.println("printMyArray");
        MyArray instance = null;
        instance.printMyArray();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElementByNumber method, of class MyArray.
     */
    @Test
    public void testGetElementByNumber() {
        System.out.println("getElementByNumber");
        int id = 0;
        MyArray instance = null;
        MyArrayElement expResult = null;
        MyArrayElement result = instance.getElementByNumber(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
