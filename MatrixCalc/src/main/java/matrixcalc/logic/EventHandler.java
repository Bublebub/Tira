
package matrixcalc.logic;

import matrixcalc.logic.dataStructure.Matrix;
import matrixcalc.logic.operations.Addition;
import matrixcalc.ui.UserInterface;


public class EventHandler {
    
    UserInterface ui;
    
    /**
     * Handles events from UI (button presses)
     * 
     * @param event integer, which is used to identify given command
     * @param a first Matrix
     * @param b second Matrix
     * @param ui UserInterface
     */
    public void handleEvent(int event, Matrix a, Matrix b, UserInterface ui) {
        
        this.ui = ui;
        
        switch (event) {
            case 0:
                Addition add = new Addition();
                add.calculate(a, b, ui);
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
