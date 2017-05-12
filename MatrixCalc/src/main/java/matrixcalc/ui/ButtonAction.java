
package matrixcalc.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import matrixcalc.logic.EventHandler;

/**
 *
 * @author Elmeri
 */
public class ButtonAction implements ActionListener {
    
    EventHandler logic;
    UserInterface ui;
    int operation;
    int[][] a, b;
    
    /**
     * Constructor
     *
     * @param eh EventHandler of the program
     * @param operationNumber number to identify the operation of a button
     * @param ui Userinterface of the program
     */
    public ButtonAction(EventHandler eh, int operationNumber, UserInterface ui ) {
        this.logic = eh;
        this.operation = operationNumber;
        this.a = new int[3][3];
        this.b = new int[3][3];
        this.ui = ui;
    }
    
    /**
     * Get matrices element values from textfields
     */
    void fetchMatricesFromUI(){
        
        int x = 0;
        int y = 0;
        
        //Used to change from a to b matrix
        int[][] temp = this.a;
        
        for (JTextField[] elementRow : this.ui.getCalculationElements()) {
            for (JTextField element : elementRow) {
                
                //Checks if input is invalid and changes it to "0"
                try {
                    temp[x][y] = Integer.parseInt(element.getText());
                    
                } catch (Exception e) {
                    
                    //Update element value
                    element.setText("0");
                    temp[x][y] = 0;
                }
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
        fetchMatricesFromUI();
        
        //Clear determinant fields
        this.ui.detA.setText("");
        this.ui.detB.setText("");
        
        //Calculate operation/event
        this.logic.handleEvent(this.operation, this.a, this.b, this.ui);
    }
    
}
