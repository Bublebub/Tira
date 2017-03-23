
package matrixcalc.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import matrixcalc.logic.EventHandler;
import matrixcalc.logic.dataStructure.Matrix;


public class ButtonAction implements ActionListener {
    
    EventHandler logic;
    int event;
    Matrix a, b;
    
    
    public ButtonAction(EventHandler eh, int eventNumber, Matrix a, Matrix b) {
        this.logic = eh;
        this.event = eventNumber;
        this.a = a;
        this.b = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.logic.handleEvent(this.event, this.a, this.b);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
