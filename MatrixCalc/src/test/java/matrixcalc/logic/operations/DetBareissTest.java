/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalc.logic.operations;

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
public class DetBareissTest {
    
    
    @Test
    public void setupRowsWorksWithStartingRowFullOfZeroes() {
        
        int[][] a = {{0, 1, 1}, {0, 1, 1}, {0, 1, 1}};
        DetBareiss instance = new DetBareiss();
        
        assertEquals(false, instance.setupRows(0, a));
    }
    
    @Test
    public void setupRowsWorksWhenSomeOtherRowIsFullOfZeroes() {
        
        int[][] a = {{1, 1, 0}, {1, 1, 0}, {1, 1, 0}};
        DetBareiss instance = new DetBareiss();
        
        assertEquals(false, instance.setupRows(0, a));
    }
    
    @Test
    public void bareissRecognizesZeroDeterminantWithoutRowsFullOfZeroes() {
        
        int[][] a = {{1, 2, 1}, {6, 3, 6}, {1, 1, 1}};
        DetBareiss instance = new DetBareiss();
        
        assertEquals(0, instance.bareiss(a));
        
    }
    
    @Test
    public void testBareiss() {
        
        int[][] a = {{1, 4, 9},{20, 50, 9},{3, 6, 8}};
        DetBareiss instance = new DetBareiss();
        
        assertEquals(-456, instance.bareiss(a));
    }
}
