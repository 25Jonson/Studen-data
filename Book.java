import java.text.NumberFormat;


public class Book {
    String bcode,tittle;
    int quantity,lended;
    double price;

    public Book(String xBcode, String xTittle, int xQuantity, int xLended, double xPrice) {
        this.bcode = xBcode;
        this.tittle = xTittle;
        this.quantity = xQuantity;
        this.lended = xLended;
        this.price = xPrice;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return bcode + "  |  " + tittle + "   |  " + quantity + "  |  " + lended + "  |  " + price ;
    }
    
        
}