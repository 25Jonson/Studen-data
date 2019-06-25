
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericLogin {

    Scanner in = new Scanner(System.in);

    Validate v = new Validate();
    private final List<User> listLogin;

    public GenericLogin() {
        listLogin = new ArrayList<>();
    }

    public void add(User d) {
        listLogin.add(d);
    }

    public void add() {
        in.useDelimiter("\n");
        System.out.print("Enter User Name: ");
        String name = in.next();
        while (checkDupplicate(name) != -1) {
            System.out.println("User Name has been Existed in date");
            add();
        }
        System.out.println("Enter Password: ");
        String pass = in.next();
        listLogin.add(new User(name, hashMD5(pass)));
    }

    public int checkDupplicate(String check) {
        int n = listLogin.size();
        int Ret = -1;
        for (int i = 0; i < n; i++) {
            User d = listLogin.get(i);
            if (d.getName().equalsIgnoreCase(check)) {
                Ret = i;
                break;
            }
        }
        return Ret;
    }

    public String hashMD5(String input) {
        try {

            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void display() {
        int n = listLogin.size();
        for (int i = 0; i < n; i++) {
            User d = listLogin.get(i);
            System.out.println(d.getName() + "\t" + d.getPassword());
        }
    }

    public void login() {
        System.out.println("==============Login Program===========");
        System.out.println("Enter User Name: ");
        String name = in.next();
        while (checkDupplicate(name) != -1) {
            System.out.println("User Name is NOT exist in data");
            login();
        }
        System.out.println("Enter Password: ");
        String pass = in.next();
        
    }
}
