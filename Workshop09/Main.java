
package Workshop09;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<DictionaryWord> dw = new ArrayList();
        dw.add(new DictionaryWord("bank robber","Steals money from a bank"));
        dw.add(new DictionaryWord("burglar","Breaks into a home to steal things"));
        dw.add(new DictionaryWord("forger","Makes an illegal copy of something"));
        dw.add(new DictionaryWord("hacker","Breaks into a computer system"));
        dw.add(new DictionaryWord("hijacker","Takes control of an airplane"));
        dw.add(new DictionaryWord("kidnapper","Holds someone for ransom money"));
        dw.add(new DictionaryWord("mugger","Attacks and steals money from someone"));
        dw.add(new DictionaryWord("murderer","Kills another person"));
        
        for (int i = 0; i < dw.size(); i++) {
            DictionaryWord x = dw.get(i);
            System.out.println(i+1+"."+dw.get(i));

        }
    }
}
