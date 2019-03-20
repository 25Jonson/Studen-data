import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        listUser lu = new listUser();
        Scanner sc = new Scanner(System.in);
        Validate v = new Validate();
        while (true) {
            displayMenu();
            int choice = v.checkchoice("Your Choice: ");
            switch (choice) {
                case 1:
                    lu.add();
                    break;
                case 2:
                    System.out.println("--------------------------------- Display all Contact ----------------------------");
                    lu.display();
                    break;
                case 3:
                    System.out.println("------- Delete a Contact -------");
                    System.out.println("Enter ID: ");
                    int deleteById = v.checkInt("");
                    lu.delete(deleteById);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("========= Contact program =========\n"
                + "1. Add a Contact\n"
                + "2. Display all Contact\n"
                + "3. Delete a Contact\n"
                + "4. Exit"
        );
    }
}
