
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
        
        int help = 0;
        
        //Divider and determinant holder
        int p = 1;
        
        //for each matrix row calculation
        for (int i = 0; i < matrix.length; i++) {
            
            //Changes 2 rows to get closer to row echelon form
            setupRows(i, matrix);
            
            //Get divider value, if its not the first calculation
            if (i != 0) {
                
                for (int x = 0; x < matrix.length; x++) {
                    
                    if (matrix[i - 1][x] != 0) {
                        p = matrix[i - 1][x];
                    }
                    
                }
            }
            
            //For each row
            for (int y = 0; y < matrix.length; y++) {
                
                //For each element
                for (int x = 0; x < matrix.length; x++) {
                    System.out.print(matrix[y][x]);
                }
                
                System.out.println("");
                
            }
            
        }
        
        return p;
        
    }
    
    /**
     * Changes rows if needed by the algorithm (change and * -1)
     * 
     * @param startingRow row number, where sorting is started from
     * @param matrix matrix to be sorted
     * @return false if the determinant is 0 at the start, true otherwise
     */
    boolean setupRows(int startingRow, int[][] matrix) {
        
        //Number of the row, that will be swapped with startingRow
        int bestRow = startingRow;
        
        //The "starting position" (of the first element != 0) in starting row
        // *used to determine the best row that will be swapped*
        int comparable = 1;
        
        for (int x = comparable; x < matrix.length; x++) {
            if (matrix[startingRow][x] == 0) {
                comparable++;
            } else break;
            
        }
        
        //If starting row is full of zeroes, determinant is 0
        if (comparable == matrix.length) {
            return false;
        }
        
        
        //Finds the best row (based on first element != 0)
        for (int nextRow = startingRow + 1; nextRow < matrix.length; nextRow++) {
            
            //For each element
            for (int x = 0; x < matrix.length; x++) {
                
                //Checks if the row is better than previous
                if (matrix[nextRow][x] != 0 && x < comparable) {
                    comparable = x;
                    bestRow = nextRow;
                    
                } else if (x >= comparable) {
                    break;
                }
                
            }
            
            //If comparable == 0, then it's the best row by default
            if (comparable == 0) {
                break;
            }
            
        }
        
        
        int[][] tempRow = new int[1][matrix.length];
        
        //Change the row elements
        for (int x = 0; x < matrix.length; x++) {
            
            //Copy the element and multiply by -1
            tempRow[0][x] = matrix[startingRow][x] * -1;
            
            //Replace copied element from "better" row
            matrix[startingRow][x] = matrix[bestRow][x];
            
            //Copy the starting rows element to the other row
            matrix[bestRow][x] = tempRow[0][x];
            
        }
        
        
        return true;
        
    }
    
    
    
}
