import java.text.DecimalFormat;
public class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        DecimalFormat dF = new DecimalFormat("0.00");
        return name + " " + dF.format(price) + " руб./шт.";
    }
}
