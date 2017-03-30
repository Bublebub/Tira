
package matrixcalc.logic.operations;

import javax.swing.JTextArea;

public class Addition {
    
    int[][] result;
    JTextArea[][] resultMatrix;
    
    public void calculate(int[][] a, int[][] b, JTextArea[][] resultMatrix) {
        result = new int[3][3];
        this.resultMatrix = resultMatrix;
        
        int x = 0;
        int y = 0;
        
        /**
         * Calculate values
         * 
         * Note to self: for an for-each-loop aren't the same thing:
         * for = operates directly on values
         * for-each = operates on a copy of values
         */
        for (int i = 0; i < result.length; i++) {
            
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = a[x][y] + b[x][y];
                
                x++;
            }
            
            y++;
            x = 0;
        }
        
        //Reset variables
        x = 0;
        y = 0;
        
        //Add values to elements
        for (int i = 0; i < this.resultMatrix.length; i++) {
            
            for (int j = 0; j < this.resultMatrix[i].length; j++) {
                
                /**
                 * Note to self: Find out where and why coordinates/matrix elements have changed (UI vs Logic structure)
                 */
                this.resultMatrix[i][j].setText(Integer.toString(result[y][x]));
                x++;
            }
            y++;
            x = 0;
        }
        
    }
    
}
