
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author PC
 */
public class AccountValidator {
    
    private final String REGEX_ACCOUNT = "^\\d{10}$";
    private final String REGEX_PASSWORD = "^(?=.*\\d)(?=.*[a-zA-Z]).{8,31}$";
    public boolean validateAccount(String account){
        return Matches(account, REGEX_ACCOUNT);
    }
    
    public boolean validatePassword(String password){
        return Matches(password, REGEX_PASSWORD);
    }
    
    private boolean Matches(String src, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        return matcher.matches();
    }
}
