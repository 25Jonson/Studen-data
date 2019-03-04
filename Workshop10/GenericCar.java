package Workshop10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericCar implements ICar {

    private List<Car> genericCar;

    public GenericCar() {
        genericCar = new ArrayList();
    }

    @Override
    public void add() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Add new Car press (a) or Exit press any key : ");
            String option = in.nextLine();
            if (option.equalsIgnoreCase("a")) {
                System.out.print("Enter Name : ");
                String carName = in.nextLine();
                System.out.print("Enter Price (USD) : ");
                Double price = Double.valueOf(in.nextLine());
                System.out.print("Enter Production : ");
                Integer production = Integer.valueOf(in.nextLine());
                genericCar.add(new Car(carName, price, production));
            } else {
                break;
            }
        }
    }

    @Override
    public void display() {
        int n = genericCar.size();
        for (int i = 0; i < n; i++) {
            Car a = genericCar.get(i);
            System.out.println(a.getName() + "\t" + a.getPrice() + "(USD)" + "\t" + a.getProduction());
        }
    }

    @Override
    public void getSize(String name) {
        int n = genericCar.size();
        boolean find = false;
        for (int i = 0; i < n; i++) {
            Car a = genericCar.get(i);
            if (a.getName().equalsIgnoreCase(name)) {
                find = true;
                System.out.println(a.getName() + "\t" + a.getPrice()+"(USD)" + "\t" + a.getProduction());
            }
        }
        if (find = false) {
            System.out.println("Given date is not exists");
        }

    }

    @Override
    public void checkEmpty(String check) {
        int n = genericCar.size();
        boolean find = false;
        for (int i = 0; i < n; i++) {
            Car a = genericCar.get(i);
            if (a.getName().equalsIgnoreCase(check)) {
                find = true;
                System.out.println(check + " is exist in list");
                break;
            }
        }
        if (find = false) {
            System.out.println("Given data is not exists");
        }
    }

    @Override
    public void delete(String remove) {
        int n = genericCar.size();
        boolean find = false;
        for (int i = 0; i < n; i++) {
            Car a = genericCar.get(i);
            if (a.getName().equalsIgnoreCase(remove)) {
                find = true;
                genericCar.remove(i);
            }
        }
        if (find = false) {
            System.out.println("Data is not exists so it is not delete");
        }
    }

}
