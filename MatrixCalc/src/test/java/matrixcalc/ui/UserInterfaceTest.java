/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalc.ui;

import javax.swing.JFrame;
import matrixcalc.logic.EventHandler;
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
public class UserInterfaceTest {
    
    public UserInterfaceTest() {
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
     * Test of run method, of class UserInterface.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        UserInterface instance = null;
        //instance.run();
    }

    /**
     * Test of createMatrixElements method, of class UserInterface.
     */
    @Test
    public void testCreateMatrixElements() {
        System.out.println("createMatrixElements");
        JFrame frame = null;
        UserInterface instance = null;
        //instance.createMatrixElements(frame);
    }

    /**
     * Test of createButtons method, of class UserInterface.
     */
    @Test
    public void testCreateButtons() {
        System.out.println("createButtons");
        JFrame frame = null;
        EventHandler eh = null;
        UserInterface instance = null;
        //instance.createButtons(frame, eh, instance);
    }

    /**
     * Test of addButtonLogic method, of class UserInterface.
     */
    @Test
    public void testAddButtonLogic() {
        System.out.println("addButtonLogic");
        EventHandler eh = null;
        UserInterface instance = null;
        //instance.addButtonLogic(eh, instance);
    }

    /**
     * Test of buttonPositionSetup method, of class UserInterface.
     */
    @Test
    public void testButtonPositionSetup() {
        System.out.println("buttonPositionSetup");
        UserInterface instance = null;
        //instance.buttonPositionSetup();
    }

    /**
     * Test of addButtonsToFrame method, of class UserInterface.
     */
    @Test
    public void testAddButtonsToFrame() {
        System.out.println("addButtonsToFrame");
        JFrame frame = null;
        UserInterface instance = null;
        //instance.addButtonsToFrame(frame);
    }
    
}
