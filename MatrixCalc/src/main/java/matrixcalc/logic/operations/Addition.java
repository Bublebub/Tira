
package matrixcalc.logic.operations;

import javax.swing.JTextArea;

public class Addition {
    
    //values for result matrix
    int[][] resultMatrixValues;
    
    //Visual elements of result matrix
    JTextArea[][] resultMatrixVisualElements;
    
    /**
     * Performs addition operation on matrices (a & b) and puts the values to result matrix elements
     * 
     * @param a First matrix
     * @param b Second matrix
     * @param resultMatrix Contains visual JTextAreas for result matrix elements
     */
    public void calculate(int[][] a, int[][] b, JTextArea[][] resultMatrix) {
        resultMatrixValues = new int[3][3];
        this.resultMatrixVisualElements = resultMatrix;
        
        /**
         * Calculate values
         * 
         * Note to self: for an for-each-loop aren't the same thing:
         * for = operates directly on values
         * for-each = operates on a copy of values
         */
        for (int y = 0; y < resultMatrixValues.length; y++) {
            for (int x = 0; x < resultMatrixValues[y].length; x++) {
                
                resultMatrixValues[y][x] = a[x][y] + b[x][y];
                
            }
        }
        
        /**
         * Add values to elements
         * 
         * Note to self: Find out where and why coordinates/matrix elements have changed (UI vs Logic structure)
         */
        for (int y = 0; y < this.resultMatrixVisualElements.length; y++) {
            for (int x = 0; x < this.resultMatrixVisualElements.length; x++) {
                
                this.resultMatrixVisualElements[y][x].setText(Integer.toString(resultMatrixValues[y][x]));
                
            }
        }
    }
    
}
