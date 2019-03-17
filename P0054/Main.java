
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {


        List phoneNumbers = new ArrayList();
        phoneNumbers.add("1234567890");
        phoneNumbers.add("123-456-7890");
        phoneNumbers.add("123.456.7890");
        phoneNumbers.add("123 456 7890");
        phoneNumbers.add("123-456-7890 x1234");
        phoneNumbers.add("(123) 456 7890");
        phoneNumbers.add("123-456-7890 ext1234");
        phoneNumbers.add("(123)-456-7890");
        phoneNumbers.add("(123) 456 7890");
        phoneNumbers.add("(123) 456 7890");

//Invalid phone numbers
        phoneNumbers.add("12345678");
        phoneNumbers.add("12-12-111");
 
        String regex3  = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})(\\se?x?t?(\\d*))?"; //yes
        Pattern pattern = Pattern.compile(regex3);

        for (Object email : phoneNumbers) {
            Matcher matcher = pattern.matcher((CharSequence) email);
            System.out.println(email + " : " + matcher.matches());
        }
    }
}
