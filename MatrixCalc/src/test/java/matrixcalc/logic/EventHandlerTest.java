/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalc.logic;

import javax.swing.JTextArea;
import matrixcalc.ui.UserInterface;
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
public class EventHandlerTest {
    
    public EventHandlerTest() {
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
     * Test of handleEvent method, of class EventHandler.
     */
    @Test
    public void testHandleEvent() {
        System.out.println("handleEvent");
        int event = 0;
        int[][] a = null;
        int[][] b = null;
        EventHandler instance = new EventHandler();
        JTextArea[][] resultMatrix = null;
        UserInterface ui = new UserInterface(instance);
        instance.handleEvent(event, a, b, ui);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
