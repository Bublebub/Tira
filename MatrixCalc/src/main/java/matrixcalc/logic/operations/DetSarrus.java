
package matrixcalc.logic.operations;

import matrixcalc.ui.UserInterface;

/**
 *
 * @author Elmeri
 */
public class DetSarrus {
    
    int temp, result, x, y;
    
    /**
     * Calculates and prints out the determinants of a &amp; b matrices (to JTextAreas)
     * using the Rule of Sarrus
     * 
     * @param a first Matrix
     * @param b second Matrix
     * @param ui UserInterface, that contains JTextAreas for determinants
     */
    public void calculate(int[][] a, int[][] b, UserInterface ui) {
        
        result = 0;
        
        //Calculate final determinant value of matrix a
        result = additionValues(a) + subtractionValues(a);
        
        //Set determinant value to correct JTextArea
        ui.getDetA().setText(Integer.toString(result));
        
        result = 0;
        
        //Calculate final determinant value of matrix b
        result = additionValues(b) + subtractionValues(b);
        
        //Set determinant value to correct JTextArea
        ui.getDetB().setText(Integer.toString(result));
        
        
    }
    
    /**
     * Value addition part of the Rule of Sarrus
     * 
     * @param matrix contains the values
     * @return result value of the addition
     */
    int additionValues(int[][] matrix) {
        
        result = y = 0;
        
        for (int i = 0; i < matrix.length; i++) {
        
            temp = 1;
            x = i;
            
            for (int j = 0; j < matrix.length; j++) {
                
                if (x == matrix.length) {
                    x = 0;
                }
                
                temp *= matrix[x][y];
                x++;
                y++;
            }
            y = 0;
            result += temp;
        }
        
        return result;
    }
    
    /**
     * Value subtraction part of the Rule of Sarrus
     * 
     * @param matrix contains the values
     * @return result value of the subtraction
     */
    int subtractionValues(int[][] matrix) {
        
        result = x = y = 0;
        
        for (int i = 0; i < matrix.length; i++) {
        
            temp = 1;
            x = (matrix.length - 1) - i;
            
            for (int j = 0; j < matrix.length; j++) {
                
                if (x < 0) {
                    x = matrix.length - 1;
                }
                
                temp *= matrix[x][y];
                x--;
                y++;
            }
            y = 0;
            result -= temp;
        }
        
        return result;
    }
    
}
