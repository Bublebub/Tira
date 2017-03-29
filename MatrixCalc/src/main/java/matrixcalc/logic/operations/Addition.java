
package matrixcalc.logic.operations;

import javax.swing.JTextArea;
import matrixcalc.logic.dataStructure.Matrix;
import matrixcalc.ui.UserInterface;

public class Addition {
    
    public void calculate(Matrix a, Matrix b, UserInterface ui) {
        Matrix result = new Matrix();
        
        int x = 0;
        int y = 0;
        int value;
        
        while (y != 3) {
            
            if (x == 3) {
                x = 0;
                y++;
            }
            
            result.setElementValue(x, y, a.getElementValue(x, y) + b.getElementValue(x, y));
            
        }
        
        addValuesToTextAreas(result, ui);
        
    }
    
    void addValuesToTextAreas(Matrix result, UserInterface ui) {
        
        int x = 0;
        int y = 0;
        int element = 0;
        JTextArea[] temp = ui.getResultElements();
        
        while (y != 3) {
            
            if (x == 3) {
                x = 0;
                y++;
            }
            
            temp[element].setText(Integer.toString(result.getElementValue(x, y)));
            
            element++;
        }
    }
    
}
