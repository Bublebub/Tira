
package matrixcalc.logic.operations;

import matrixcalc.ui.UserInterface;


public class Determinant {
    
    int temp, result, x, y;
    
    public void calculate(int[][] a, int[][] b, UserInterface ui) {
        
        result = 0;
        
        result = additionValues(a) + subtractionValues(a);
        
        ui.getDetA().setText(Integer.toString(result));
        
        result = 0;
        
        result = additionValues(b) + subtractionValues(b);
        
        ui.getDetB().setText(Integer.toString(result));
        
        
    }
    
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
                
                //System.out.println(temp);
                
                System.out.println(" " + x + " " + y);
                
                x++;
                y++;
            }
            
            y = 0;
            
            result += temp;
        }
        
        System.out.println(" ");
        
        return result;
    }
    
    int subtractionValues(int[][] matrix) {
        
        result = x = y = 0;
        
        for (int i = 0; i < matrix.length; i++) {
        
            temp = 1;
            
            x = (matrix.length - 1) - i;
            
            for (int j = 0; j < matrix.length; j++) {
                
                if (x < 0) {
                    x = matrix.length - 1;
                }
                
                //System.out.println(" " + x + " " + y);
                
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
