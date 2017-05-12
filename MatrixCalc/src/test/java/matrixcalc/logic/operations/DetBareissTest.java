
package matrixcalc.logic.operations;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elmeri
 */
public class DetBareissTest {
    
    /**
     * setupRows recognizes a starting row full of zeroes
     */
    @Test
    public void setupRowsWorksWithStartingRowFullOfZeroes() {
        
        int[][] a = {{0, 1, 1}, {0, 1, 1}, {0, 1, 1}};
        DetBareiss instance = new DetBareiss();
        
        assertEquals(false, instance.setupRows(0, a));
    }
    
    /**
     * setupRows recognizes a row full of zeroes (other than starting row)
     */
    @Test
    public void setupRowsWorksWhenSomeOtherRowIsFullOfZeroes() {
        
        int[][] a = {{1, 1, 0}, {1, 1, 0}, {1, 1, 0}};
        DetBareiss instance = new DetBareiss();
        
        assertEquals(false, instance.setupRows(0, a));
    }
    
    /**
     * bareiss calculates determinant 0, even if there are no rows full of zeroes
     */
    @Test
    public void bareissRecognizesZeroDeterminantWithoutRowsFullOfZeroes() {
        
        int[][] a = {{1, 2, 1}, {6, 3, 6}, {1, 1, 1}};
        DetBareiss instance = new DetBareiss();
        
        assertEquals(0, instance.bareiss(a));
        
    }
    
    /**
     * bareiss gives the correct answer
     */
    @Test
    public void testBareiss() {
        
        int[][] a = {{1, 4, 9}, {20, 50, 9}, {3, 6, 8}};
        DetBareiss instance = new DetBareiss();
        
        assertEquals(-456, instance.bareiss(a));
    }
}
