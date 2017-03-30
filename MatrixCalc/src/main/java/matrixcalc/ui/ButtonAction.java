
package matrixcalc.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import matrixcalc.logic.EventHandler;


public class ButtonAction implements ActionListener {
    
    EventHandler logic;
    UserInterface ui;
    int operation;
    int[][] a, b;
    
    
    public ButtonAction(EventHandler eh, int operationNumber, UserInterface ui ) {
        this.logic = eh;
        this.operation = operationNumber;
        this.a = new int[3][3];
        this.b = new int[3][3];
        this.ui = ui;
    }
    
    //Get matrices element values from textfields
    void addMatricesFromUI(){
        
        int x = 0;
        int y = 0;
        
        //Used to change from a to b matrix
        int[][] temp = this.a;
        
        for (JTextField[] elementRow : this.ui.getCalculationElements()) {
            
            if (elementRow == null) {
                break;
            }
            
            for (JTextField element : elementRow) {
                
                if (element == null) {
                    System.out.println("ei onnistu");
                    continue;
                }
                
                System.out.println("onnistui" + element.getText());
                
                String text = element.getText();
                
                temp[x][y] = Integer.parseInt(text);
                
                //Change element
                x++;
            }
            //Change row and return x to its start
            y++;
            x = 0;

            //Change to matrix b when a is full
            if (y == 3) {
                temp = this.b;
                y = 0;
            }
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Get matrix values from UI
        addMatricesFromUI();
        
        
        //Calculate operation/event
        this.logic.handleEvent(this.operation, this.a, this.b, this.ui.getResultElements());
        
    }
    
}
