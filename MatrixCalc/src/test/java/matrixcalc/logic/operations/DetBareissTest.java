
package matrixcalc.logic.operations;

import org.junit.Test;
import static org.junit.Assert.*;


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
        
        int[][] a = {{1, 4, 9}, {20, 50, 9}, {3, 6, 8}};
        DetBareiss instance = new DetBareiss();
        
        assertEquals(-456, instance.bareiss(a));
    }
}
