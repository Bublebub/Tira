
package matrixcalc.logic;

import javax.swing.JTextArea;
import matrixcalc.logic.operations.Addition;
import matrixcalc.logic.operations.Multiplication;
import matrixcalc.logic.operations.Subtraction;
import matrixcalc.logic.operations.Determinant;
import matrixcalc.ui.UserInterface;

public class EventHandler {
    
    JTextArea[][] resultMatrixVisualElements;
    
    /**
     * Handles events from UI (button presses)
     * 
     * @param event used to identify given command
     * @param a first Matrix
     * @param b second Matrix
     * @param ui contains JTextAreas of result matrix elements and determinants
     */
    public void handleEvent(int event, int[][] a, int[][] b, UserInterface ui) {
        
        this.resultMatrixVisualElements = ui.getResultElements();
        
        switch (event) {
            case 0:
                Addition add = new Addition();
                add.calculate(a, b, this.resultMatrixVisualElements);
                break;
            case 1:
                Subtraction sub = new Subtraction();
                sub.calculate(a, b, this.resultMatrixVisualElements);
                break;
            case 2:
                Multiplication mul = new Multiplication();
                mul.calculate(a, b, this.resultMatrixVisualElements);
                break;
            case 3:
                Determinant det = new Determinant();
                det.calculate(a, b, ui);
                break;
            default:
                break;
        }
    }
    
}
