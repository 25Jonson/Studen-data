
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("A phone number only has the following format:"
                + "•	1234567890\n"
                + "•	123-456-7890\n"
                + "•	123-456-7890 x1234\n"
                + "•	123-456-7890 ext1234\n"
                + "•	(123)-456-7890\n"
                + "•	123.456.7890\n"
                + "•	123 456 7890");
        String phone = "123 456 7890";
        System.out.println(phone.length());
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your phone: ");
        String phone1 = sc.nextLine();
        if (phone1.matches("[0-9]{10}")
                || phone1.length() == 12 && phone1.trim().charAt(3) == '-' && phone1.trim().charAt(7) == '-'
                || phone1.length() == 17 && phone1.trim().charAt(3) == '-' && phone1.trim().charAt(7) == '-' && phone1.trim().substring(12).equalsIgnoreCase("x1234")
                || phone1.length() == 19 && phone1.trim().charAt(3) == '-' && phone1.trim().charAt(7) == '-' && phone1.trim().substring(12).equalsIgnoreCase("ext1234")
                || phone1.length() == 14 && phone1.trim().charAt(0) == '(' && phone1.trim().charAt(4) == ')' && phone1.trim().charAt(5) == '-' && phone1.trim().charAt(9) == '-'
                || phone1.length() == 12 && phone1.trim().charAt(3) == '.' && phone1.trim().charAt(7) == '.'
                || phone1.length() == 12 && phone1.trim().charAt(3) == ' ' && phone1.trim().charAt(7) == ' ') {
            System.out.println("Eccept");
        } else {
            System.out.println("NOT");
        }
    }

}
