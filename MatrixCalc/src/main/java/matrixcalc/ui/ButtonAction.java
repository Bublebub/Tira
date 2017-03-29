
package matrixcalc.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import matrixcalc.logic.EventHandler;


public class ButtonAction implements ActionListener {
    
    EventHandler logic;
    int operation;
    JTextArea[][] resultMatrix;
    int[][] a, b;
    
    
    public ButtonAction(EventHandler eh, int operationNumber, JTextArea[][] resultMatrix ) {
        this.logic = eh;
        this.operation = operationNumber;
        this.a = new int[3][3];
        this.b = new int[3][3];
        this.resultMatrix = resultMatrix;
        
    }
    
    //Get matrices element values from textfields
    void addMatricesFromUI(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Get matrix values from UI
        addMatricesFromUI();
        
        //Calculate operation/event
        this.logic.handleEvent(this.operation, this.a, this.b, this.resultMatrix);
        
    }
    
}
