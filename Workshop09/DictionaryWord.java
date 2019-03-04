
package Workshop09;

public class DictionaryWord {
   private String word;
   private String meanings;

    public DictionaryWord() {
        word = meanings = "";
    }

    public DictionaryWord(String word, String meanings) {
        this.word = word;
        this.meanings = meanings;
    }

    public String getMeaningsl() {
        return meanings;
    }

    public String getWord() {
        return word;
    }

    public void setMeaningsl(String meanings) {
        this.meanings = meanings;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return getWord()+"\n"+getMeaningsl();
    }
   
}
