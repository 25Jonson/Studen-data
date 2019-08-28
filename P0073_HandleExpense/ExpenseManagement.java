
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseManagement {

    Validator v = new Validator();
    private final List<Expense> listExpense;

    public ExpenseManagement() {
        listExpense = new ArrayList<>();
    }
    //add information of worker

    public void add() {
        Scanner in = new Scanner(System.in);
        int id = 1;
        if (checkIsExis(id) != -1) {
            id++;
        }
        String date = v.getDate();

        System.out.println("Enter amount of money: ");
        double money = v.checkDouble("");
        System.out.println("Enter content: ");
        String content = v.checkString("");

        listExpense.add(new Expense(id, date, money, content));
    }

    //Check exis if it is dupplicate return -1 else return i
    public int checkIsExis(int checkID) {
        int n = listExpense.size();
        int ret = -1;
        for (int i = 0; i < n; i++) {
            Expense e = listExpense.get(i);
            if (e.getId() == checkID) {
                ret = i;
//                System.out.println(check + " is exis!");
                break;
            }
        }
        return ret;
    }

    public void display() {
        int n = listExpense.size();
        double totalMoney = 0;
        System.out.printf("%-10s%-20s%-20s%-20s\n", "ID", "Name", "Amount of money", "Content");
        for (int i = 0; i < n; i++) {
            Expense e = listExpense.get(i);
            System.out.printf("%-10d%-20s%-20.1f%-20s\n", e.getId(), e.getDate(), e.getMoney(), e.getContent());
            totalMoney += e.getMoney();
        }
        System.out.printf("Total: %-10.1f", totalMoney);
    }

    public void deleteByID(int removeID) {
        boolean find = false;
        if (checkIsExis(removeID) != -1) {
            find = true;
            listExpense.remove(checkIsExis(removeID));
            System.out.println("Successful==");
        }
        if(find == false){
            System.out.printf("[%d] is NOT existed in data so that is NOT delete",removeID);
        }
    }

}
