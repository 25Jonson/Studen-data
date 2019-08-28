
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Main {
    private static ResourceHelper resourceHelper = new ResourceHelper();
    
    private static void displayMenu(){
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }
    
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        
        System.out.println("========= Login Program====== ");
        while(true){
            displayMenu();
            int option = inputValidator.inputIntegerInRange("Please choice one option: ", 1, 3);
            switch(option){
                case 1:
                    resourceHelper.setLanguage("Vietnamese");
                    checkLogin();
                    break;
                case 2:
                    resourceHelper.setLanguage("English");
                    checkLogin();
                    break;
                case 3: System.exit(0);
            }
        }
    }
    
    private static void checkLogin(){
        
        AccountValidator accountValidator = new AccountValidator();
        Scanner scanner = new Scanner(System.in);
        CaptchaHelper captchaHelper = new CaptchaHelper();
        
        while(true){
            System.out.print(resourceHelper.getWord("AccountMg")+": ");
            String account = scanner.nextLine();
            boolean isValid = accountValidator.validateAccount(account);
            if(isValid) break;
            else System.out.println(resourceHelper.getWord("InvalidAccountMg"));
        }

        while(true){
            System.out.print(resourceHelper.getWord("PasswordMg")+": ");
            String password = scanner.nextLine();
            boolean isValid = accountValidator.validatePassword(password);
            if(isValid) break;
            else System.out.println(resourceHelper.getWord("InvalidPasswordMg"));
        }
        
        while(true){
            System.out.print(resourceHelper.getWord("CaptchaMg")+": ");
            String srcCaptcha = captchaHelper.createCaptcha(5);
            System.out.print(srcCaptcha);
            System.out.println("");
            System.out.println(resourceHelper.getWord("Re-enterCaptcha"));
            String desCaptcha = scanner.nextLine();
            boolean isMatches = captchaHelper.checkCaptcha(srcCaptcha, desCaptcha);
            if(isMatches) break;
            else {
                System.out.println(resourceHelper.getWord("InvalidCaptcha"));
                System.out.println(resourceHelper.getWord("Re-enterCaptcha"));
            }
        }
        
        System.out.println("Login is successfully");
    }
}
