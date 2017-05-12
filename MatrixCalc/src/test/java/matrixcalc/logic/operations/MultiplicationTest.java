
package matrixcalc.logic.operations;

import javax.swing.JTextArea;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elmeri
 */
public class MultiplicationTest {
    
    JTextArea c11, c12, c13, c21, c22, c23, c31, c32, c33;
    
    JTextArea[][] tempMatrix = {{c11, c12, c13},
                                {c21, c22, c23}, 
                                {c31, c32, c33}};
    
    /**
     * calculate gives the correct answer
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
        
        Multiplication instance = new Multiplication();
        
        instance.calculate(a, b, tempMatrix);
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (Integer.parseInt(tempMatrix[i][j].getText()) != 18) {
                    works = false;
                }
            }
        }
        
        assertEquals(true, works);
        
    }
    
}
