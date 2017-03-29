
package matrixcalc.ui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import matrixcalc.logic.EventHandler;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class UserInterface implements Runnable{

    JFrame frame;
    EventHandler logic;
    
    //Textfields for matrix elements (a & b , 3x3)
    JTextField a11, a12, a13,
               a21, a22, a23,
               a31, a32, a33,
            
               b11, b12, b13,
               b21, b22, b23,
               b31, b32, b33;
    
    //Temporary array for editable matrix element creation ( a & b )
    JTextField[] elementContainer = {a11, a12, a13, a21, a22, a23, a31, a32, a33, 
                                  b11, b12, b13, b21, b22, b23, b31, b32, b33};
    
    //Textareas for result matrix ( c , 3x3 )
    JTextArea c11, c12, c13, 
              c21, c22, c23, 
              c31, c32, c33;
    
    //Temporary array for result matrix creation ( c )
    JTextArea[] resultElements = {c11, c12, c13, c21, c22, c23, c31, c32, c33};
    
    
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
        createResultTextAreas(frame);
        createButtons(frame, this.logic, this);
        
        frame.setVisible(true);
        
        frame.pack();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Creates editable matrix elements to given JFrame
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
        for (JTextField element : elementContainer) {
            
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
     * Creates textareas for calculation result elements
     * 
     * @param frame JFrame, where elements (JTextAreas) are assigned to
     */
    void createResultTextAreas(JFrame frame) {
        
        int x = 425;
        int y = 40;
        
        for (JTextArea element : resultElements) {
            
            if (x > 530){
                y += 35;
                x = 425;
            }
            
            element = new JTextArea();
            
            element.setEditable(false);
            
            element.setBounds(x, y, 35, 25);
            
            frame.add(element);
            
            x += 50;
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
    void createButtons(JFrame frame, EventHandler eh, UserInterface ui) {
        addButtonLogic(eh, ui);
        buttonPositionSetup();
        addButtonsToFrame(frame);
    }
    
    /**
     * Adds actionlisteners to buttons
     * 
     * VALUES: 0 = addition, 1 = subtraction, 2 = multiplication, 3 = determinant
     * Note to self; change values to constants!
     * 
     * @param eh EventHandler, that handles button events
     * @param a first Matrix
     * @param b second Matrix
     */
    void addButtonLogic(EventHandler eh, UserInterface ui) {
        addBtn.addActionListener(new ButtonAction(eh, 0, ui));
        subBtn.addActionListener(new ButtonAction(eh, 1, ui));
        mulBtn.addActionListener(new ButtonAction(eh, 2, ui));
        detBtn.addActionListener(new ButtonAction(eh, 3, ui));
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
    
    
    public JTextField[] getElementContainer() {
        return this.elementContainer;
    }
    
    public JTextArea[] getResultElements() {
        return this.resultElements;
    }
    
}
