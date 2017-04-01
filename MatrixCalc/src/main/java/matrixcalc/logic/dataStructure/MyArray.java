
package matrixcalc.logic.dataStructure;

/**
 * 
 * NOT USED AT THE MOMENT
 * 
 */
public class MyArray {
    
    int size, helper;
    MyArrayElement start, prev, next;
    
    /**
     * Contructor, that creates an array of the given size
     * 
     * @param size array size, number of elements
     */
    public MyArray(int size) {
        this.size = size;
        this.helper = 1;
        this.start = new MyArrayElement();
        
        createMyArray();
    }
    
    /**
     * Creates the array elements !! Note to self: REMEMBER TO ADD VALUES !!
     */
    final void createMyArray() {
        
        //Setup
        this.start.setID(0);
        prev = this.start;
        
        if (this.size > 1) {
            
            while (this.helper < size) {
                
                //Create new cell, id = 1
                next = new MyArrayElement();
                next.setID(this.helper);
                
                //Set as next element of the previous
                prev.setNext(next);
                
                //Set prev to point to "present" element
                prev = next;
                
                this.helper++;
                
            }
            
        }
        
    }
    
    /**
     * Prints array element ID's
     */
    public void printMyArray() {
        
        next = this.start.getNext();
        
        this.start.printID();
        
        while (next != null) {
            next.printID();
            
            next = next.getNext();
        }
        
        
    }
    
    /**
     * Gets element pointed by given ID
     * 
     * @param id ID used to find the corresponding element
     * @return element by given id, null if not found
     */
    public MyArrayElement getElementByNumber(int id) {
        
        if (id > this.size || id <= 0) {
            return null;
        }
        
        //first cell is 0, second is 1, etc.
        id--;
        
        if (this.start.getID() == id) {
            return this.start;
            
        } else {
            next = this.start.getNext();
            
            while (next != null) {
                
                if (next.id == id) {
                    return next;
                }
                next = next.getNext();
                
            }
            
        }
        
        return null;
    }
    
}
