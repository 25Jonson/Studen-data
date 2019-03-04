
package Workshop10;

public class Car {
    private String name;
    private double price;
    private int production;

    public Car() {
        name = "";
        price = production = 0;
    }

    public Car(String name, double price, int production) {
        this.name = name;
        this.price = price;
        this.production = production;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getProduction() {
        return production;
    }
    
}
