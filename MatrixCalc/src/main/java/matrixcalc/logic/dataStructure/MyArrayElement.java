
package matrixcalc.logic.dataStructure;


/**
 * 
 * NOT USED AT THE MOMENT
 * 
 */
public class MyArrayElement {
    
    int id, value;
    MyArrayElement next;
    
    /**
     * Prints elements ID
     */
    public void printID() {
        System.out.println(this.id);
    }
    
    //Setters
    
    void setID(int id) {
        this.id = id;
    }
    
    void setValue(int newValue) {
        this.value = newValue;
    }
    
    void setNext(MyArrayElement next) {
        this.next = next;
    }
    
    
    //Getters
    
    int getID() {
        return this.id;
    }
    
    int getValue() {
        return this.value;
    }
    
    MyArrayElement getNext() {
        return this.next;
    }
    
}
