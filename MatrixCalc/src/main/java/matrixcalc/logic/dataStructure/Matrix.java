
package matrixcalc.logic.dataStructure;

/**
 * 
 * NOT USED AT THE MOMENT
 * 
 */
public class Matrix {
    
    int[][] elements;
    
    
    public Matrix() {
        this.elements = new int[3][3];
        
    }
    
    public void setElementValue(int x, int y, int value) {
        this.elements[x][y] = value;
        
    }
    
    public int getElementValue(int x, int y) {
        return this.elements[x][y];
        
    }
}
