
package matrixcalc.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import matrixcalc.logic.EventHandler;
import matrixcalc.logic.dataStructure.Matrix;


public class ButtonAction implements ActionListener {
    
    EventHandler logic;
    int operation;
    UserInterface ui;
    Matrix a, b;
    
    
    public ButtonAction(EventHandler eh, int operationNumber, UserInterface ui) {
        this.logic = eh;
        this.operation = operationNumber;
        this.ui = ui;
        this.a = new Matrix();
        this.b = new Matrix();
    }
    
    //Get matrices element values from textfields
    void addMatricesFromUI(){
        
        JTextField[] temp = this.ui.getElementContainer();
        
        int x = 0;
        int y = 0;
        int value;
        
        //For matrix a
        for (int i = 0; i < 9; i++) {
            
            if (x == 3) {
                y++;
                x = 0;
            }
            
            //Get value from textfield
            value = Integer.parseInt(temp[i].getText());
            
            //Assign value to a corresponding element
            this.a.setElementValue(x, y, i);
            
        }
        
        //For matrix b
        for (int i = 9; i < 18; i++) {
            
            if (x == 3) {
                y++;
                x = 0;
            }
            
            //Get value from textfield
            value = Integer.parseInt(temp[i].getText());
            
            //Assign value to a corresponding element
            this.b.setElementValue(x, y, i);
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Get matrix values from UI
        addMatricesFromUI();
        
        //Calculate operation/event
        this.logic.handleEvent(this.operation, this.a, this.b, this.ui);
        
    }
    
}
