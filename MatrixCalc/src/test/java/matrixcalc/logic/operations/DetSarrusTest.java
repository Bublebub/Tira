
package matrixcalc.logic.operations;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elmeri
 */
public class DetSarrusTest {
    
    /**
     * additionValues gives the correct answer
     */
    @Test
    public void testAdditionValues() {
       int[][] a = {{1, 4, 9}, {20, 50, 9}, {3, 6, 8}};
       DetSarrus instance = new DetSarrus();
       
       assertEquals(1588, instance.additionValues(a));
    }
    
    /**
     * subtractionValues gives the correct answer
     */
    @Test
    public void testSubstractionValues() {
        int[][] a = {{1, 4, 9}, {20, 50, 9}, {3, 6, 8}};
       DetSarrus instance = new DetSarrus();
       
       assertEquals(-2044, instance.subtractionValues(a));
    }
    
}
