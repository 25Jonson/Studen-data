
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Main {
    
    private static void displayMenu(){
        System.out.println("WELLCOME TO STUDENT MANAGEMENT");
        System.out.println("1.   Create");
        System.out.println("2.   Find and Sort");
        System.out.println("3.   Update/Delete");
        System.out.println("4.   Report");
        System.out.println("5    Exit");
        System.out.print("Plese choose 1 to 5: ");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();
        while(true){
            displayMenu();
            int option = Integer.parseInt(scanner.nextLine());
            switch(option){
                case 1:
                    int countStudent = 0;
                    while(true){
                        service.addNewStudent();
                        countStudent++;
                        if(countStudent==2){
                            System.out.println("Do you want to add more (Y/N)");
                            String choice = scanner.nextLine();
                            if(choice == "Y") continue;
                            else break;
                        }
                    }
                    break;
                case 2: 
                    service.findAndSort();
                    break;
                case 3:
                    service.updateAndDelete();
                    break;
                case 4:
                    service.studentReport();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Wrong selection!");
                    break;
            }
        }
    }
}
