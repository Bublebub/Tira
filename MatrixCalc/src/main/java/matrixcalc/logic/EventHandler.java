
package matrixcalc.logic;

import javax.swing.JTextArea;
import matrixcalc.logic.operations.Addition;
import matrixcalc.ui.UserInterface;


public class EventHandler {
    
    JTextArea[][] resultMatrix;
    
    /**
     * Handles events from UI (button presses)
     * 
     * @param event integer, which is used to identify given command
     * @param a first Matrix
     * @param b second Matrix
     * @param resultMatrix contains JTextAreas, where the result of calculation will be written
     */
    public void handleEvent(int event, int[][] a, int[][] b, JTextArea[][] resultMatrix) {
        
        this.resultMatrix = resultMatrix;
        
        switch (event) {
            case 0:
                Addition add = new Addition();
                add.calculate(a, b, this.resultMatrix);
                break;
            case 1:
                System.out.println("minus");
                break;
            case 2:
                System.out.println("multi");
                break;
            case 3:
                System.out.println("det");
                break;
            default:
                break;
        }
    }
    
}
