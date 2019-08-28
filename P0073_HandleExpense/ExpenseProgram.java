
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseProgram {

    public static void main(String[] args) throws IOException {
        ExpenseManagement e = new ExpenseManagement();
        Scanner sc = new Scanner(System.in);

        Validator v = new Validator();
        while (true) {
            System.out.println("==========================");
            displayMenu();
            int choice = v.checkchoice("Your Choice: ");
            switch (choice) {
                case 1:

                    e.add();
                    break;
                case 2:
                    System.out.println("====Expense Management====");
                    e.display();
                    break;
                case 3:
                    System.out.println("Enter ID to delete: ");
                    int id = v.checkInt("");
                    e.deleteByID(id);
                    break;
          
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("====Expense Program====\n"
                + "1. Add an expense\n"
                + "2. Display all expenses\n"
                + "3. Remove an expense\n"
                + "4. Exit"
        );
    }
}
