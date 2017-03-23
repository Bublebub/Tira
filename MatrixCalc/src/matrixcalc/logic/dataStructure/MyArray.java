
package matrixcalc.logic.dataStructure;

public class MyArray {
    
    int size, helper;
    MyArrayElement start, prev, next;
    
    
    public MyArray(int size) {
        this.size = size;
        this.helper = 1;
        this.start = new MyArrayElement();
        
        createMyArray();
    }
    
    void createMyArray() {
        
        //Alustus 1. solmu/solu, id = 0
        this.start.setID(0);
        prev = this.start;
        
        if (this.size > 1) {
            
            while (this.helper < size) {
                
                //Luodaan uusi solu, id = 1
                next = new MyArrayElement();
                next.setID(this.helper);
                
                //Asetetaan edellisen solmun jatkoksi
                prev.setNext(next);
                
                //Asetetaan osoittamaan uuteen solmuun
                prev = next;
                
                this.helper++;
                
            }
            
        }
        
    }
    
    public void printMyArray() {
        
        next = this.start.getNext();
        
        this.start.printID();
        
        while (next != null) {
            next.printID();
            
            next = next.getNext();
        }
        
        
    }
    
    //Return null if not found
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
