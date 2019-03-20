
import java.util.Scanner;

public class Validate {

    Scanner sc = new Scanner(System.in);

    public int checkchoice(String message) {
        int a = 0;
        while (true) {
            try {
                System.out.print(message);
                a = Integer.parseInt(sc.nextLine());
                if ((a >= 1 && a <= 4)) {
                    break;
                } else {
                    System.out.println("Re-input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
            } catch (NullPointerException e) {
                System.out.println("Please don't input space!");
            }
        }
        return a;
    }

    public int checkInt(String message) {
        int a = 0;
        while (true) {
            try {
                System.out.print(message);
                a = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
            } catch (NullPointerException e) {
                System.out.println("Please don't input space!");
            } catch (ArithmeticException e) {
                System.out.println("Please don't division for 0!");
            }
        }
        return a;
    }

    public String checkString(String message) {
        String a;
        while (true) {
            try {
                System.out.print(message);
                a = sc.nextLine();
                if (a.trim().equals("") || a == null) {
                    System.out.println("Please input");
                } else {
                    break;
                }
            } catch (NullPointerException e) {
                System.out.println("Please don't input space!");
            }
        }
        return a;
    }

    public String checkPhone() {
        Scanner sc = new Scanner(System.in);
        boolean result = false;
        String intInput = "";
        do {
            String digit = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})(\\se?x?t?(\\d*))?";
            intInput = sc.nextLine();
            try {
                result = intInput.matches(digit);
                if (intInput.trim().isEmpty()) {
                    System.out.println("Input is not blank. Input again: ");
                    result = false;
                } else if (!result) {
                    System.out.println("Please input Phone flow");
                    System.out.println("•	1234567890\n"
                            + "•	123-456-7890\n"
                            + "•	123-456-7890 x1234\n"
                            + "•	123-456-7890 ext1234\n"
                            + "•	(123)-456-7890\n"
                            + "•	123.456.7890\n"
                            + "•	123 456 7890");
                    System.out.print("Enter Phone: ");
                    result = false;
                } 
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!result);
        return intInput;
    }
}
