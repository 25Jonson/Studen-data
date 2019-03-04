
package Workshop10;


public interface ICar {
    public void add(); //add new item of T to a
    public void display(); //display all items of a
    public void getSize(String name); //return the number item of a
    public void checkEmpty(String check); //check and return whether a is empty or not
    //public void delete(int pos); //remove the item at the position pos of a. 
    public void delete(String remove);
    
            
}
