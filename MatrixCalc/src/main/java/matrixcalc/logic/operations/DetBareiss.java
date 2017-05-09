
package matrixcalc.logic.operations;

import matrixcalc.ui.UserInterface;


public class DetBareiss {
    
    /**
     * Calculates and prints out the determinants of a & b matrices (to JTextAreas)
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
     * Bareiss algorithm, that calculates the determinant of given matrix
     * 
     * @param matrix input matrix
     * @return determinant of the given matrix
     */
    int bareiss(int[][] matrix){
        
        //Divider
        int p = 1;
        //Used to determine, which row should be skipped
        int skipRow = 0;
        int[][] tempMatrix;
        
        //For each calculation
        for (int calcNum = 0; calcNum < matrix.length; calcNum++) {
            
            //Used to check for determinant value 0
            boolean change = setupRows(calcNum, matrix);
            
            //Copies matrix, so that it can be used to perform the calculation
            tempMatrix = copyMatrix(matrix);
            
            //Find column number, row number == calcNum
            int column = findColumn(matrix, calcNum);
            
            //All the rows are valid
            if (change) {
                
                //Calculates the values for new matrix
                calculateNewMatrix(matrix, tempMatrix, skipRow, column, calcNum, p);
                
            } else {
                return 0;
            }
            
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
    
    int findFirstNonZero(int[][] matrix, int startingRow) {
        int firstNonZero = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][startingRow] != 0) {
                break;
            } else {
                firstNonZero++;
            }
        }
        return firstNonZero;
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
    
    //Finds the column number for the formula of calculation
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
    
    void calculateNewMatrix(int[][] matrix, int[][] tempMatrix, int skipRow, int column, int calcNum, int p) {
        //For each row
        for (int i = 0; i < matrix.length; i++) {
            
            //For each element
            for (int j = 0; j < matrix.length; j++) {
                    
                if (i == skipRow) {
                    continue;
                } else {
                    matrix[j][i] = (tempMatrix[column][calcNum] * tempMatrix[j][i]) - (tempMatrix[column][i] * tempMatrix[j][calcNum]);
                    matrix[j][i] /= p;
                }
            }
        }
    }
    
}
