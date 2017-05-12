
package matrixcalc.logic.operations;

import javax.swing.JTextArea;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elmeri
 */
public class AdditionTest {

    JTextArea c11, c12, c13, c21, c22, c23, c31, c32, c33;
    
    JTextArea[][] tempMatrix = {{c11, c12, c13},
                                {c21, c22, c23}, 
                                {c31, c32, c33}};
    
    /**
     * Test that calculate works
     */
    @Test
    public void testCalculate() {
        
        int[][] a = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        int[][] b = {{3, 3, 3}, {3, 3, 3}, {3, 3, 3}};
        boolean works = true;
        
        for (JTextArea[] elementRow : tempMatrix) {
            for (int j = 0; j < elementRow.length; j++) {
                elementRow[j] = new JTextArea("");
            }
        }
        
        Addition instance = new Addition();
        
        instance.calculate(a, b, tempMatrix);
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (Integer.parseInt(tempMatrix[i][j].getText()) != 5) {
                    works = false;
                }
            }
        }
        
        assertEquals(true, works);
    }
}
