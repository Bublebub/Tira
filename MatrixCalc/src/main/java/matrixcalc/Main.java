
package matrixcalc;

import matrixcalc.logic.dataStructure.MyArray;
import matrixcalc.logic.dataStructure.MyArrayElement;
import matrixcalc.ui.UserInterface;
import matrixcalc.logic.EventHandler;


public class Main {

    
    public static void main(String[] args) {
        
        System.out.println("TESTI");
        
        EventHandler logic = new EventHandler();
        
        UserInterface ui = new UserInterface(logic);
        
        ui.run();
        
        MyArray ar = new MyArray(6);
        
        ar.printMyArray();
        
        MyArrayElement x = ar.getElementByNumber(2);
        
        
        if (x != null) {
            x.printID();
        } else {
            System.out.println("error");
        }
        
    }
    
}
