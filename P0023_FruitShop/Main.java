
import Entities.*;
import Functions.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main_Menu menu = new Main_Menu();
        Create_Fruit creFru = new Create_Fruit();
        Shopping shop = new Shopping();
        ViewOrder view = new ViewOrder();
        ArrayList<Fruit> fruitList = new ArrayList<>();
        ArrayList<StoreOrder> orderList = new ArrayList<>();
        boolean end = false;

        do {
            //MAIN MENU
            int choice;
            menu.printMainMenu();
            choice = menu.getMainMenuChoice();

            //FUNCTIONS
            switch (choice) {
                case 1: { //create fruit
                    fruitList = creFru.createFruit(fruitList);
                    creFru.displayCreatedFruit(fruitList);
                    break;
                }
                case 2: { //view order
                    view.viewOder(orderList);
                    break;
                }
                case 3: { //shopping (for buyers)
                    orderList = shop.getCustomerOrder(fruitList);
                    break;
                }
                case 4: { //exit program
                    end = true;
                    break;
                }
            }
        } while (end == false);
    }

}
