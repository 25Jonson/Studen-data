
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        int n = 0;
        int a[] = null;
        String s;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            menu();
            int choice;
            do {
                do {
                    s = sc.next();
                } while ((choice = checkInt(s)) == -1);
                switch (choice) {
                    case 1:
                        System.out.println("Input length of array: ");
                        do {
                            s = sc.next();
                        } while ((n = checkInt(s)) == -1);
                        a = new int[n];
                        for (int i = 0; i < n; i++) {
                            System.out.println("Enter number " + i + ": ");
                            do {
                                s = sc.next();
                            } while ((a[i] = checkInt(s)) == -1);
                        }
                        break;
                    case 2:
                        if (a.length == 1) {
                            System.err.println("Array Empty");
                        } else {
                            sort(n, a, choice);
                        }
                        break;
                    case 3:
                        if (a.length == 1) {
                            System.err.println("Array Empty");
                        } else {
                            sort(n, a, choice);
                        }
                        break;
                    case 4:
                        flag = false;
                        break;
                    default:
                        System.err.println("Enter choice 1 - 4!!!");
                }
            } while (choice < 1 || choice > 4);
        }
    }

    private static void menu() {
        System.out.println("=========== Bubble Sort Program ===========");
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Deascending");
        System.out.println("4. Exit");
    }

    private static void sort(int n, int[] a, int c) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("Sorted Array: ");
        if (c == 2) {
            displayA(n, a);
        }
        if (c == 3) {
            displayD(n, a);
        }
    }

    private static void displayA(int n, int[] a) {
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.println(a[i] + "\n");
            } else {
                System.out.println(a[i] + ", ");
            }
        }
    }

    private static void displayD(int n, int[] a) {
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.println(a[i] + "\n");
            } else {
                System.out.println(a[i] + ", ");
            }
        }
    }

    private static int checkInt(String n) {
        try {
            int num;
            num = Integer.parseInt(n);
            if (num < 1) {
                System.err.println("Please input a number and number greater than Zero!!!");
                return -1;
            } else {
                return num;
            }
        } catch (Exception e) {
            System.err.println("Please input a number and number greater than Zero!!!");
            return -1;
        }
    }

}
