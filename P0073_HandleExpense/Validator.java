
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {

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

    public double checkDouble(String message) {
        double a = 0;
        while (true) {
            try {
                System.out.print(message);
                a = Double.parseDouble(sc.nextLine());
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

    public String checkDate(String message) {
        String a;
        while (true) {
            try {
                System.out.print(message);
                a = sc.nextLine();
                Pattern pattern = Pattern.compile("\\d{1,2}[-][Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec][-]\\d{4}");
                if (a == null) {
                    System.out.println("Please input follow tyle: 12-Jan-2000");
                } else if (Integer.parseInt(a.trim().substring(0, 1)) > 31) {
                    System.out.println("Date must be in range 1 to 31");} else {
                    break;
                }
            } catch (NullPointerException e) {
                System.out.println("Please don't input space!");
            }
        }
        return a;
    }

    public boolean checkSpecialYear(String year) {
        int checkYear = Integer.parseInt(year.substring(7));
        boolean result = false;
        if (checkYear % 4 == 0) {
            if (checkYear % 100 == 0) {
                if (checkYear % 400 == 0) {
//                    System.out.println("This is năm nhuận");
                    result = true;
                }
            } else {
                result = true;
//                System.out.println("This is năm nhuận");
            }
        }
        return result;
    }

}
