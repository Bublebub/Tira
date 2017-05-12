
package matrixcalc.ui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import matrixcalc.logic.EventHandler;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author Elmeri
 */
public class UserInterface implements Runnable{

    //Frame for all UI components
    JFrame frame;
    
    //Handles operations based on given command (button press)
    EventHandler logic;
    
    //Textfields for matrix elements (a & b , 3x3)
    JTextField a11, a12, a13,
               a21, a22, a23,
               a31, a32, a33,
            
               b11, b12, b13,
               b21, b22, b23,
               b31, b32, b33;
    
    //Temporary array for editable matrix element creation ( a & b )
    JTextField[][] calculationElements = {{a11, a12, a13}, 
                                          {a21, a22, a23}, 
                                          {a31, a32, a33}, 
                                       
                                          {b11, b12, b13}, 
                                          {b21, b22, b23}, 
                                          {b31, b32, b33}};
    
    //Textareas for result matrix ( c , 3x3 ) and matrix determinants ( a & b )
    JTextArea c11, c12, c13, 
              c21, c22, c23, 
              c31, c32, c33, detA, detB;
    
    //Temporary array for result matrix creation ( c )
    JTextArea[][] resultElements = {{c11, c12, c13},
                                    {c21, c22, c23}, 
                                    {c31, c32, c33}};
    
    
    //Buttons for operations
    JButton addBtn = new JButton("+"), 
            subBtn = new JButton("-"), 
            mulBtn = new JButton("*"), 
            detBtnSarrus = new JButton("detSa"),
            detBtnBareiss = new JButton("detBa");
    
    /**
     * Constructor, that connects program logic and UI
     * 
     * @param eh Handles operations
     */
    public UserInterface(EventHandler eh) {
        this.logic = eh;
        
        for (JTextField[] calculationElement : calculationElements) {
            for (int j = 0; j < calculationElement.length; j++) {
                calculationElement[j] = new JTextField("");
            }
        }
        
        for (JTextArea[] elementRow : resultElements) {
            for (int j = 0; j < elementRow.length; j++) {
                elementRow[j] = new JTextArea("");
            }
        }
        
        detA = new JTextArea("detA");
        detB = new JTextArea("detB");
    }
    
    @Override
    public void run() {
        
        frame = new JFrame();
        
        frame.setPreferredSize(new Dimension(640,300));
        frame.setResizable(false);
        
        frame.setLayout(null);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //Create visible matrix elements (for a and b matrix, JTextFields)
        createMatrixElements(frame);
        
        //Create visible matrix elements ((for result matrix, JTextAreas)
        createResultTextAreas(frame);
        
        //Create buttons for operations
        createButtons(frame, this.logic, this);
        
        frame.setVisible(true);
        
        frame.pack();
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
        
        //Used to switch x and y values for matrix b
        int help = 0;
        
        //Sets element coordinates and adds them to given frame
        for (JTextField[] elementRow : this.calculationElements) {
            
            for (JTextField element : elementRow) {
            
                //Set element coordinates
                element.setBounds(x, y, 35, 25);
                
                //Add element to JFrame
                frame.add(element);
                
                x += 50;
                help++;
            }
            
            if (help == 9) {
                x = 225;
                y = 40;
            } else if (help > 9) {
                x = 225;
                y += 35;
            } else {
                y += 35;
                x = 40;
            }
            
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
        
        for (JTextArea[] elementRow  : this.resultElements) {
            
            for (JTextArea element : elementRow) {
            
                element.setEditable(false);
                element.setBounds(x, y, 35, 25);
                frame.add(element);
                
                x += 50;
            }
            y += 35;
            x = 425;
        }
        
        //JTextAreas for determinants
        detA.setEditable(false);
        detB.setEditable(false);
        
        detA.setBounds(385, 170, 100, 30);
        detB.setBounds(505, 170, 100, 30);
        
        frame.add(detA);
        frame.add(detB);
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
     * 
     * @param eh EventHandler, that handles button events
     * @param a first Matrix
     * @param b second Matrix
     */
    void addButtonLogic(EventHandler eh, UserInterface ui) {
        addBtn.addActionListener(new ButtonAction(eh, 0, this));
        subBtn.addActionListener(new ButtonAction(eh, 1, this));
        mulBtn.addActionListener(new ButtonAction(eh, 2, this));
        detBtnSarrus.addActionListener(new ButtonAction(eh, 3, this));
        detBtnBareiss.addActionListener(new ButtonAction(eh, 4, this));
    }
    
    /**
     * Sets button positions
     */
    void buttonPositionSetup() {
        addBtn.setBounds(40, 165, 45, 40);
        subBtn.setBounds(90, 165, 45, 40);
        mulBtn.setBounds(140, 165, 45, 40);
        detBtnSarrus.setBounds(190, 165, 70, 40);
        detBtnBareiss.setBounds(265, 165, 70, 40);
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
        frame.add(detBtnSarrus);
        frame.add(detBtnBareiss);
    }
    
    //-------- Getters -------------

    public JTextField[][] getCalculationElements(){
        return this.calculationElements;
    }
    
    public JTextArea[][] getResultElements() {
        return this.resultElements;
    }
    
    public JTextArea getDetA() {
        return this.detA;
    }
    
    public JTextArea getDetB() {
        return this.detB;
    }
    
}
