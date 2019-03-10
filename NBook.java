
public class NBook {
    Book info;
    NBook next;

    public NBook() {
    }

    public NBook(Book info) {
        this(info, null);
    }

    public NBook(Book info, NBook next) {
        this.info = info;
        this.next = next;
    }
    
}
