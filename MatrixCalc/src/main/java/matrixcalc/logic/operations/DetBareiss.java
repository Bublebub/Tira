
package matrixcalc.logic.operations;

import matrixcalc.ui.UserInterface;


public class DetBareiss {
    
    /**
     * Calculates and prints out the determinants of a & b matrices (to JTextAreas)
     * using the Bareiss algorithm
     * 
     * Note to self: clean up this code
     * 
     * @param a first Matrix
     * @param b second Matrix
     * @param ui UserInterface, that contains JTextAreas for determinants
     */
    public void calculate(int[][] a, int[][] b, UserInterface ui) {
        
        System.out.println("a " + bareiss(a));
        System.out.println("b " + bareiss(b));
    }
    
    /**
     * Bareiss algorithm, that calculates the determinant of given matrix
     * 
     * @param matrix input matrix
     * @return determinant of the given matrix
     */
    int bareiss(int[][] matrix){
        
        int p = 1;
        
        boolean change = setupRows(0, matrix);
        
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                
                //X ja Y??
                System.out.print(matrix[j][i] + " ");
            }
            
            System.out.println("");
        }
        
        System.out.println("");
        
        if (change) {
            p = 200;
        }
        
        return p;
        
    }
    
    /**
     * Changes rows if needed by the algorithm (change and * -1)
     * 
     * @param startingRow row number, where sorting is started from
     * @param matrix matrix to be sorted
     * @return false if the determinant is 0 (some row is full of zeroes), true otherwise
     */
    boolean setupRows(int startingRow, int[][] matrix) {
        
        int firstNonZero = 0;
        
        //-----------------------ZERO CHECK START-----------------------------------------
        
        //Finds the position of first non zero element
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][startingRow] != 0) {
                break;
            } else {
                firstNonZero++;
            }
        }
        
        //Starting row is full of zeroes, return false
        if (firstNonZero == matrix.length) {
            return false;
        }
        
        
        int nonZeroCounter = 0;
        int currentBest = firstNonZero;
        int bestRow = startingRow;
        
        //Finds the best replacing row (with smallest non Zero element value)
        for (int i = startingRow + 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                
                if (matrix[j][i] == 0) {
                    nonZeroCounter++;
                    
                //Update values, if the row is better than current
                } else if (matrix[j][i] != 0 && nonZeroCounter < currentBest) {
                    
                    currentBest = nonZeroCounter;
                    bestRow = i;
                    break;
                    
                //Change row, if it's not better and contains at least one non zero value 
                } else if (matrix[j][i] != 0) {
                    break;
                }
                
                if (j == matrix.length - 1) {
                    
                    //Found row full of zeroes, return false
                    return false;
                }
                
            }
            
            
            nonZeroCounter = 0;
        }
        
        //-----------------------ZERO CHECK END-----------------------------------------
        
        //Starting row is the best row & no other row is full of zeroes, return true
        if (firstNonZero == 0) {
            return true;
        }
        
        int tempRow[][] = new int[matrix.length][1];
        
        //If better row is found, multiply starting row elements by -1 and change rows
        if (currentBest < firstNonZero) {
            
            //Multiply starting row elements
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][startingRow] *= -1;
            }
            
            //Change rows
            for (int i = 0; i < matrix.length; i++) {
                tempRow[i][0] = matrix[i][startingRow];
                matrix[i][startingRow] = matrix[i][bestRow];
                matrix[i][bestRow] = tempRow[i][0];
            }
            
            //Better row has been found and changed
            return true;
        }
        
        //Starting row is "equal" with the best row, no need to change
        return true;
    }
    
    
    
}
