
package matrixcalc;

import matrixcalc.logic.dataStructure.MyArray;
import matrixcalc.logic.dataStructure.MyArrayElement;
import matrixcalc.ui.UserInterface;


public class Main {

    
    public static void main(String[] args) {
        
        UserInterface ui = new UserInterface();
        
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
