
package matrixcalc.ui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import matrixcalc.logic.EventHandler;
import javax.swing.JButton;
import matrixcalc.logic.dataStructure.Matrix;


public class UserInterface implements Runnable{

    JFrame frame;
    EventHandler logic;
    
    Matrix a, b;
    
    //Textfields for matrix cells (3x3)
    JTextField a11, a12, a13,
               a21, a22, a23,
               a31, a32, a33,
            
               b11, b12, b13,
               b21, b22, b23,
               b31, b32, b33;
    
    //Temporary array for matrix cell creation
    JTextField[] cellContainer = {a11, a12, a13, a21, a22, a23, a31, a32, a33, 
                                  b11, b12, b13, b21, b22, b23, b31, b32, b33};
    
    //Buttons for operations
    JButton addBtn = new JButton("+"), 
            subBtn = new JButton("-"), 
            mulBtn = new JButton("*"), 
            detBtn = new JButton("det");
    
    /**
     * Constructor, that connects program logic and UI
     * 
     * @param eh Handles command logic
     */
    public UserInterface(EventHandler eh) {
        this.logic = eh;
    }
    
    @Override
    public void run() {
        
        frame = new JFrame();
        
        frame.setPreferredSize(new Dimension(640,480));
        frame.setResizable(false);
        
        frame.setLayout(null);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //Create visible Matrix cells (JTextFields)
        createMatrixElements(frame);
        createButtons(frame, this.logic, a, b);
        
        frame.setVisible(true);
        
        frame.pack();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Creates editable Matrix elements to given JFrame
     * 
     * @param frame JFrame, where elements (JTextfields) are assigned to
     */
    void createMatrixElements(JFrame frame) {
        
        //Cells x and y coordinations
        int x = 40;
        int y = 40;
        
        //Used to assign cells to right rows
        int rowCounter = 0;
        
        //Creates each element to specific row and adds them to JFrame
        for (JTextField element : cellContainer) {
            
            //Sets correct coordinates for each cell
            switch (rowCounter) {
                case 3:
                case 6:
                    y += 35;
                    x = 40;
                    break;
                case 9:
                    y = 40;
                    x = 225;
                    break;
                case 12:
                case 15:
                    y += 35;
                    x = 225;
                    break;
                default:
                    break;
            }
            
            //Create new cell
            element = new JTextField();
            
            //Set cell coordinates
            element.setBounds(x, y, 35, 25);
            
            //Add cell to JFrame
            frame.add(element);
            
            //Change new coordinates and row number
            x += 50;
            rowCounter++;
        }
        
    }
    
    /**
     * Combines functions to create Buttons to given JFrame
     * 
     * @param frame JFrame, where buttons are assigned to
     * @param eh EventHandler, that handles button events
     * @param a first Matrix
     * @param b second Matrix
     */
    void createButtons(JFrame frame, EventHandler eh, Matrix a, Matrix b) {
        addButtonLogic(eh, a, b);
        buttonPositionSetup();
        addButtonsToFrame(frame);
    }
    
    /**
     * Adds actionlisteners to buttons
     * 
     * @param eh EventHandler, that handles button events
     * @param a first Matrix
     * @param b second Matrix
     */
    void addButtonLogic(EventHandler eh, Matrix a, Matrix b) {
        addBtn.addActionListener(new ButtonAction(eh, 0, a, b));
        subBtn.addActionListener(new ButtonAction(eh, 1, a, b));
        mulBtn.addActionListener(new ButtonAction(eh, 2, a, b));
        detBtn.addActionListener(new ButtonAction(eh, 3, a, b));
    }
    
    /**
     * Sets button positions
     */
    void buttonPositionSetup() {
        addBtn.setBounds(20, 200, 45, 40);
        subBtn.setBounds(80, 200, 45, 40);
        mulBtn.setBounds(130, 200, 45, 40);
        detBtn.setBounds(180, 200, 70, 40);
    }
    
    /**
     * Adds buttons to given frame
     * 
     * @param frame JFrame, where buttons are assigned to
     */
    void addButtonsToFrame(JFrame frame) {
        frame.add(addBtn);
        frame.add(subBtn);
        frame.add(mulBtn);
        frame.add(detBtn);
    }
    
}
