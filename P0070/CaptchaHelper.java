
import java.util.Random;

/**
 *
 * @author PC
 */
public class CaptchaHelper {
    private String CHARECTERS = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    
    public String createCaptcha(int n){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<n;i++){
            char charecter = CHARECTERS.charAt(random.nextInt(CHARECTERS.length()));
            stringBuilder.append(charecter);
        }
        return stringBuilder.toString();
    }
    
    
    public boolean checkCaptcha(String src, String des){
        return src.matches(des);
    }
}
