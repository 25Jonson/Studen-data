
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 *
 * @author PC
 */
public class ResourceHelper {
    
    private Map supportedLanguage;
    private ResourceBundle resourceBundle;

    public ResourceHelper() {
        // default supported language
        supportedLanguage = new HashMap();
        supportedLanguage.put("Vietnamese", new Locale("vi", "VN"));
        supportedLanguage.put("English", Locale.US);
    }
        
    public void setLanguage(String langName){
        resourceBundle = ResourceBundle.getBundle("Message",(Locale)supportedLanguage.get(langName));
    }
    
    public String getWord(String key){
        return resourceBundle.getString(key);
    }
    
}
