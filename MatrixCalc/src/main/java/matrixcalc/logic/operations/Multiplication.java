
package matrixcalc.logic.operations;

import javax.swing.JTextArea;


public class Multiplication {
    
    //values for result matrix
    int[][] resultMatrixValues;
    
    //Visual elements of result matrix
    JTextArea[][] resultMatrixVisualElements;
    
    /**
     * Performs multiplication operation on matrices (a & b) and puts the values to result matrix elements
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
         */
        for (int y = 0; y < resultMatrixValues.length; y++) {
            
            for (int x = 0; x < resultMatrixValues[y].length; x++) {
                resultMatrixValues[y][x] = (a[0][y] * b[x][0]) + (a[1][y] * b[x][1]) + (a[2][y] * b[x][2]);
                
            }
            
        }
        
        
        //Add values to elements
        for (int y = 0; y < this.resultMatrixVisualElements.length; y++) {
            
            for (int x = 0; x < this.resultMatrixVisualElements[y].length; x++) {
                
                /**
                 * Note to self: Find out where and why coordinates/matrix elements have changed (UI vs Logic structure)
                 */
                this.resultMatrixVisualElements[y][x].setText(Integer.toString(resultMatrixValues[y][x]));
            }
        }
        
    }
    
}
