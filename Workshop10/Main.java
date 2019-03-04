
package Workshop10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ICar ic = new GenericCar();
      
        
        ic.add();        
        ic.display();
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a name to search number : ");
        String name = in.nextLine();
        ic.getSize(name);
        
        System.out.print("Enter a name to check :");
        String check = in.nextLine();
        ic.checkEmpty(check);
      
        
        System.out.print("Enter a name to remove :");
        String remove = in.nextLine();
        ic.delete(remove);
        ic.display();
    }
}
