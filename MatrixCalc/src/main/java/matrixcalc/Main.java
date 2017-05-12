
package matrixcalc;

import matrixcalc.ui.UserInterface;
import matrixcalc.logic.EventHandler;

/**
 *
 * @author Elmeri
 */
public class Main {
    
    public static void main(String[] args) {
        
        EventHandler logic = new EventHandler();
        
        UserInterface ui = new UserInterface(logic);
        
        ui.run();
        
    }
    
}
