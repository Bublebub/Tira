
package matrixcalc.logic.operations;

import javax.swing.JTextArea;

public class Addition {
    
    int[][] result;
    JTextArea[][] resultMatrix;
    
    public void calculate(int[][] a, int[][] b, JTextArea[][] resultMatrix) {
        this.result = new int[3][3];
        this.resultMatrix = resultMatrix;
        
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
        
        for (int[] p : this.result) {
            for (int i : p) {
                System.out.print(i + "");
            }
        }
        
        //Add values to elements
        for (JTextArea[] elementRow : this.resultMatrix) {
            
            for (JTextArea element : elementRow) {
                element.setText(Integer.toString(this.result[x][y]));
                x++;
            }
            y++;
            x = 0;
        }
        
        
    }
    
}
