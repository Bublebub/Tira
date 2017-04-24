
package matrixcalc.logic;

import javax.swing.JTextArea;
import matrixcalc.logic.operations.Addition;
import matrixcalc.logic.operations.Multiplication;
import matrixcalc.logic.operations.Subtraction;

public class EventHandler {
    
    JTextArea[][] resultMatrixVisualElements;
    
    /**
     * Handles events from UI (button presses)
     * 
     * @param event used to identify given command (values: 0 = addition, 1 = subtraction, 2 = multiplication, 3 = determinant)
     * @param a first Matrix
     * @param b second Matrix
     * @param resultMatrix contains JTextAreas of result matrix elements
     */
    public void handleEvent(int event, int[][] a, int[][] b, JTextArea[][] resultMatrix) {
        
        this.resultMatrixVisualElements = resultMatrix;
        
        switch (event) {
            case 0:
                Addition add = new Addition();
                add.calculate(a, b, this.resultMatrixVisualElements);
                break;
            case 1:
                Subtraction sub = new Subtraction();
                sub.calculate(a, b, resultMatrix);
                break;
            case 2:
                Multiplication mul = new Multiplication();
                mul.calculate(a, b, resultMatrix);
                break;
            case 3:
                System.out.println("det");
                break;
            default:
                break;
        }
    }
    
}
