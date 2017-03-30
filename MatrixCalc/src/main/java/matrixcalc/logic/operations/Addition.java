
package matrixcalc.logic.operations;

import javax.swing.JTextArea;

public class Addition {
    
    int[][] result;
    JTextArea[][] resultM;
    
    public void calculate(int[][] a, int[][] b, JTextArea[][] resultMatrix) {
        this.result = new int[3][3];
        this.resultM = resultMatrix;
        
        int x = 0;
        int y = 0;
        
        //Calculate values
        for (int[] row : this.result) {
            
            for (int value : row) {
                value = a[x][y] + b[x][y];
                
                System.out.print(value + " ");
                
                x++;
            }
            
            y++;
            x = 0;
        }
        
        //Reset variables
        x = 0;
        y = 0;
        
        //Add values to elements
        for (JTextArea[] elementRow : this.resultM) {
            
            for (JTextArea element : elementRow) {
                element.setText("0");
                x++;
            }
            y++;
            x = 0;
        }
        
        
    }
    
}
