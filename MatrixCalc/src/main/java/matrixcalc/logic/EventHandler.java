
package matrixcalc.logic;

import javax.swing.JTextArea;
import matrixcalc.logic.operations.Addition;
import matrixcalc.logic.operations.DetBareiss;
import matrixcalc.logic.operations.Multiplication;
import matrixcalc.logic.operations.Subtraction;
import matrixcalc.logic.operations.DetSarrus;
import matrixcalc.ui.UserInterface;

/**
 *
 * @author Elmeri
 */
public class EventHandler {
    
    JTextArea[][] resultMatrixVisualElements;
    
    /**
     * Handles events from UI (button presses)
     * 
     * @param event used to identify given command (values: 0 = addition, 1 = subtraction, 2 = multiplication, 3 = determinant)
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
                DetSarrus detSa = new DetSarrus();
                //Calculate determinants using the Rule of Sarrus
                detSa.calculate(a, b, ui);
                break;
            case 4:
                DetBareiss detBa = new DetBareiss();
                //Calculate determinants using the Bareiss algorithm
                detBa.calculate(a, b, ui);
            default:
                break;
        }
    }
    
}
