
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class InputValidator {
    
    private Scanner scanner;

    public InputValidator() {
        scanner = new Scanner(System.in);
    }
    
    public int inputIntegerInRange(String message,int min, int max){
        System.out.print(message);
        while(true){
            try{
                int number = Integer.parseInt(scanner.nextLine());
                if(number>=min && number<=max){
                    return number;
                }
                else System.out.println("Please enter number in rage "+min+" "+max);
//                if(number < min || number > max){
//                    System.out.println("Please enter number in rage "+min+" "+max);
//                    continue;
//                }
//                return number;
            }
            catch(NumberFormatException ex){
                System.out.println("Invalid number! Please enter number");
            }
        }
        
        
    }
    
    public double inputDoubleInRange(String message,double min, double max){
        System.out.print(message);
        while(true){
            try{
                double number = Double.parseDouble(scanner.nextLine());
                if(number>=min && number<=max){
                    return number;
                }
                else System.out.println("Please enter number in rage "+min+" "+max);
            }
            catch(NumberFormatException ex){
                System.out.println("Invalid number! Please enter number");
            }
        }
    }

    public String inputStringNonEmpty(String message){
        System.out.print(message);
        while(true){
            String inputString = scanner.nextLine();
            inputString = inputString.trim();
            if(inputString.isEmpty() || inputString.length() == 0){
                System.out.println("Please enter non-empty string");
                continue;
            }
            return inputString;
        }
    }

    //get valid date
    public String inputDate(String mess) {
        System.out.print(mess);
        //set format of date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        //force user input exectly a date
        while(true) {
            String input = scanner.nextLine();
            try {
                Date date = dateFormat.parse(input);
                dateFormat = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
                return dateFormat.format(date);
            } catch (Exception e) {
                System.out.print("Please input valid date (dd-MM-yyyy): ");
            }
        }
    }
}
