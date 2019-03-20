
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class listUser {

    private List<User> contactUser;
    Validate v = new Validate();

    public listUser() {
        contactUser = new ArrayList<>();
    }

    public void add(User u) {
        contactUser.add(u);
    }

    public void add() {
        Scanner in = new Scanner(System.in);
        int id = 1;
        in.useDelimiter("\n");
        System.out.print("Enter a list users numbers\n--------------------\n(1 - Continue,0 - exit) : ");
        String number = in.next();
        while (!number.equalsIgnoreCase("0")) {
            if (number.equalsIgnoreCase("1")) {
                System.out.println("------- Add a Contact -------");
                System.out.print("Enter Name: ");
                String name = in.next();
                System.out.print("Enter Group: ");
                String group = in.next();
                System.out.print("Enter Address: ");
                String address = in.next();
                System.out.print("Enter Phone: ");
                String phone = v.checkPhone();

                //Khi trung name + phone se nhap lai
                while (checkDupplicate(name, phone) == true) {
                    System.out.println("Enter name again: ");
                    name = in.next();
                    System.out.println("Enter phone again: ");
                    phone = v.checkPhone();
                }
                for (int i = 0; i < contactUser.size(); i++) {
                    id = contactUser.get(i).getId() + 1;
                }
                contactUser.add(new User(id, name.trim(), group.trim(), address.trim(), phone));
                System.out.println("Successful");
            }
            System.out.print("Enter a list doctor numbers\n--------------------\n(1 - Continue,0 - exit) :");
            number = in.next();
        }
    }

    public boolean checkDupplicate(String checkName, String checkPhone) {
        String check2 = checkName.toLowerCase(); // chuyen ve cung 1 dang mau
        int n = contactUser.size();
        boolean find = false;
        for (int i = 0; i < n; i++) {
            User u = contactUser.get(i);
            if (u.getFullName().trim().equalsIgnoreCase(check2) && u.getPhone().equalsIgnoreCase(checkPhone)) {
                find = true;
                System.out.println("Name: " + checkName + "\t" + "Phone: " + checkPhone + " is exist in list");
                break;
            }
        }
        return find;
    }

    public void display() {
        int n = contactUser.size();
        for (int i = 0; i < n; i++) {
            User u = contactUser.get(i);
            String[] st = u.getFullName().split("\\s+");
            String firstName = st[0];
            String lastName = st[st.length - 1];
            System.out.println(u.getId() + "\t" + u.getFullName() + "\t" + firstName
                    + "\t" + lastName + "\t" + u.getGroup() + "\t" + u.getPhone());
        }
    }

    public void delete(int removeById) {
        boolean find = false;
        for (int i = 0; i < contactUser.size(); i++) {
            if (contactUser.get(i).getId() == removeById) {
                find = true;
                contactUser.remove(i);
                System.out.println("Successful");
            }
        }
        if (find == false) {
            System.out.println("Data is not exists so it is not delete");
        }
    }
}
