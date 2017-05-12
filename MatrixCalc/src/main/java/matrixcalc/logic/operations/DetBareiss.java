
package matrixcalc.logic.operations;

import matrixcalc.ui.UserInterface;

/**
 *
 * @author Elmeri
 */
public class DetBareiss {
    
    
    /**
     * Calculates and prints out the determinants of a &amp; b matrices (to JTextAreas)
     * using the Bareiss algorithm
     * 
     * @param a first Matrix
     * @param b second Matrix
     * @param ui UserInterface, that contains JTextAreas for determinants
     */
    public void calculate(int[][] a, int[][] b, UserInterface ui) {
        
        ui.getDetA().setText(Integer.toString(bareiss(a)));
        ui.getDetB().setText(Integer.toString(bareiss(b)));
        
    }
    
    /**
     * Bareiss algorithm that calculates the determinant of given matrix
     * 
     * @param matrix input matrix
     * @return determinant of the given matrix
     */
    int bareiss(int[][] matrix){
        
        //Divider
        int p = 1;
        //Used to determine which row should be skipped
        int skipRow = 0;
        
        //For each calculation
        for (int calcNum = 0; calcNum < matrix.length; calcNum++) {
            
            //Used to check for determinant value 0
            boolean change = setupRows(calcNum, matrix);
            
            //Copies matrix, so that it can be used to perform the calculation
            int[][] tempMatrix = copyMatrix(matrix);
            
            //Find column number, row number == calcNum (used to find out divider p value)
            int column = findColumn(matrix, calcNum);
            
            //All the rows are valid
            if (change) {
                
                //Calculates the values for new matrix
                calculateNewMatrix(matrix, tempMatrix, skipRow, column, calcNum, p);
                
            } else {
                return 0;
            }
            
            //Column and calculation number (== row number) are needed to find out the divider
            p = matrix[column][calcNum];
            skipRow++;
        }
        
        //Return the final element of the matrix ( == determinant)
        return matrix[matrix.length - 1][matrix.length - 1];
    }
    
    /**
     * Changes rows if needed by the algorithm (change and * -1)
     * Also checks for rows full of zeroes (guaranteed zero determinant)
     * 
     * @param startingRow row number, where sorting is started from
     * @param matrix matrix to be sorted
     * @return false if the determinant is 0 (some row is full of zeroes), true otherwise
     */
    boolean setupRows(int startingRow, int[][] matrix) {
        
        //-----------------------ZERO CHECK START-----------------------------------------
        
        //Finds the position of first non zero element
        int firstNonZero = findFirstNonZero(matrix, startingRow);
        
        //Starting row is full of zeroes, return false
        if (firstNonZero == matrix.length) {
            return false;
        }
        
        int currentBest = firstNonZero;
        int bestRow = startingRow;
        
        //Finds the best replacing row (with smallest non Zero element value)
        //If row full of zeroes is found, returns false
        if (!searchForBetterRow(matrix, startingRow, currentBest, bestRow)) {
            return false;
        }
        
        //-----------------------ZERO CHECK END-----------------------------------------
        
        //Starting row is the best row & no other row is full of zeroes, return true
        if (firstNonZero == 0) {
            return true;
        }
        
        //If better row is found, multiply starting row elements by -1 and change rows
        if (currentBest < firstNonZero) {
            
            //Multiply starting row elements
            multiplyMatrixRowElements(matrix, startingRow, -1);
            
            //Swaps rows
            swapMatrixRows(matrix, startingRow, bestRow);
            
            //Better row has been found and changed
            return true;
        }
        
        //Starting row is "equal" with the best row, no need to change
        return true;
    }
    
    /**
     * Finds and returns the place of first non zero element in a given row
     * 
     * @param matrix matrix that contains the row of elements
     * @param rowNumber number of the row which contains the elements
     * @return the place of first non zero element
     */
    int findFirstNonZero(int[][] matrix, int rowNumber) {
        int firstNonZero = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][rowNumber] != 0) {
                break;
            } else {
                firstNonZero++;
            }
        }
        return firstNonZero;
    }
    
    /**
     * Searches for better row to be swapped with the startingRow
     * and updates the values accordingly
     * 
     * @param matrix matrix containing the rows
     * @param startingRow first row, best one at the start
     * @param currentBest currently best non zero elements place
     * @param bestRow the best row found (smallest nonZeroCounter value, has first non zero element)
     * @return false if row full of zeroes is found, true otherwise
     */
    boolean searchForBetterRow(int[][] matrix, int startingRow, int currentBest, int bestRow) {
        
        //Used to keep track on the amount of zeroes
        int nonZeroCounter = 0;
        
        //For each row after startingRow
        for (int i = startingRow + 1; i < matrix.length; i++) {
            
            //For each element
            for (int j = 0; j < matrix.length; j++) {
                
                if (matrix[j][i] == 0) {
                    nonZeroCounter++;
                    
                //Update values, if the row is better than current one
                } else if (matrix[j][i] != 0 && nonZeroCounter < currentBest) {
                    currentBest = nonZeroCounter;
                    bestRow = i;
                    break;
                    
                //Change row, if it's not better and contains at least one non zero value 
                } else if (matrix[j][i] != 0) {
                    break;
                }
                
                //Found row full of zeroes, return false
                if (j == matrix.length - 1) {
                    return false;
                }
            }
            nonZeroCounter = 0;
        }
        return true;
    }
    
    /**
     * Multiplies row elements by given value
     * 
     * @param matrix contains the row
     * @param rowNumber rows number, used to search from matrix
     * @param multiplier value used to multiply row elements
     */
    void multiplyMatrixRowElements(int[][] matrix, int rowNumber, int multiplier) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][rowNumber] *= multiplier;
        }
    }
    
    /**
     * Swaps two rows inside the given matrix
     * 
     * @param matrix matrix containing the rows
     * @param firstRow first row to be swapped
     * @param secondRow second row to be swapped
     */
    void swapMatrixRows(int[][] matrix, int firstRow, int secondRow) {
        int tempRow[][] = new int[matrix.length][1];
        
        for (int i = 0; i < matrix.length; i++) {
            tempRow[i][0] = matrix[i][firstRow];
            matrix[i][firstRow] = matrix[i][secondRow];
            matrix[i][secondRow] = tempRow[i][0];
        }
    }
    
    /**
     * Copies and returns given matrix
     * 
     * @param matrix matrix to be copied
     * @return copy of matrix
     */
    int[][] copyMatrix(int[][] matrix) {
        
        int x = 0;
        int y = 0;
        int[][] newMatrix = new int[matrix.length][matrix.length];
        
        for (int[] row : matrix) {
            for (int element : row) {
                newMatrix[y][x] = element;
                x++;
            }
            x = 0;
            y++;
        }
        return newMatrix;
    }
    
    /**
     * Finds the column number for the formula of calculation
     * 
     * @param matrix matrix used in the calculation
     * @param calcNum number of calculation (affects the column number)
     * @return number of column
     */
    int findColumn(int[][] matrix, int calcNum) {
        int column = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][calcNum] != 0) {
                column = i;
                break;
            }
        }
        return column;
    }
    
    /**
     * Calculates new values for matrix elements using the formula of calculation
     * 
     * @param matrix matrix containing the elements
     * @param tempMatrix temporary matrix used for calculating (contains previous element values)
     * @param skipRow number of row that will be skipped in the calculation
     * @param column column value needed to calculate the right elements (dividers column)
     * @param row row value needed to calculate the right elements (dividers row, also calculation number)
     * @param p divider of the formula
     */
    void calculateNewMatrix(int[][] matrix, int[][] tempMatrix, int skipRow, int column, int row, int p) {
        //For each row
        for (int i = 0; i < matrix.length; i++) {
            
            //For each element
            for (int j = 0; j < matrix.length; j++) {
                if (i == skipRow) {
                    continue;
                } else {
                    matrix[j][i] = (tempMatrix[column][row] * tempMatrix[j][i]) - (tempMatrix[column][i] * tempMatrix[j][row]);
                    matrix[j][i] /= p;
                }
            }
        }
    }
    
}
