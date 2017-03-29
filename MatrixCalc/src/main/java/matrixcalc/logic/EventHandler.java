
package matrixcalc.logic;

import matrixcalc.logic.dataStructure.Matrix;


public class EventHandler {
    
    
    /**
     * Handles events from UI (button presses)
     * 
     * @param event integer, which is used to identify given command
     * @param a first Matrix
     * @param b second Matrix
     */
    public void handleEvent(int event, Matrix a, Matrix b) {
        switch (event) {
            case 0:
                System.out.println("plus");
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
