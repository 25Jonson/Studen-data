
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) throws Exception {
        BSTree t = new BSTree();
        Validate v = new Validate();
        while (true) {
            displayMenu();
            int choice = v.checkchoice("Your Choice: ");
            switch (choice) {
                case 1:
                    t.loadFile("book.txt");
                    System.out.println("Code  |  Title      |  Quantity     |  Lended  |  Price   | Value   ");
                    t.display();
                    break;
                case 2:
                    t.insert();
                    t.bal();
                    break;
                case 3:
                    t.inOrder(t.root);
                    break;
                case 4:
                    t.breadth(t.root);
                    break;
                case 5:
                    t.inOrderToFile(t.root);
                    t.inOrder(t.root);
                    break;
                case 6:
                    String xbcode = "5";
                    t.search(t.root, xbcode);
                    break;
                case 7:
                    String xcode = "2";
                    t.deleByCopy(xcode);
                    break;
                case 8:
                    t.balance();
                    break;
                case 9:
                    t.count(t.root);
                    break;
                case 11:
                    t.loadFile("book.txt");
                    System.out.println("Code  |  Title      |  Quantity     |  Lended  |  Price   | Value   ");
                    t.display();
                    break;
                case 12:
                    Book b = new Book("5", "X", 2, 1, 1);
                    t.insert(b);
                    t.breadth(t.root);
                    t.display();
                    break;
                case 13:
                    String a = "4";
                    t.search(t.root, a);
                    t.breadth(t.root);
                    break;
                case 14:
                    String c = "6";
                    t.deleByCopy(c);
                    t.breadth(t.root);
                    t.display();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Book list:\n"
                + "1.1.      Load data from file\n"
                + "1.2.      Input & insert data\n"
                + "1.3.      In-order traverse\n"
                + "1.4.      Breadth-first traverse\n"
                + "1.5.      In-order traverse to file\n"
                + "1.6.      Search by bcode\n"
                + "1.7.      Delete by bcode by copying\n"
                + "1.8.      Simply balancing\n"
                + "1.9.      Count number of books\n"
                + "1.11.     Count number of books\n"
                + "1.12.     Insert\n"
                + "1.13.     Search\n"
                + "1.14.     Delete\n"
                + "1.15.     Balance\n"
        );

    }
}
