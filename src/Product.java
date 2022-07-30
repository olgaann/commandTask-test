import java.text.DecimalFormat;
public class Product {
    public String name;
    public double price;
    public boolean threeAsTwo; //поле для акции "три по цене двух"

    public Product(String name, double price, boolean threeAsTwo) {
        this.name = name;
        this.price = price;
        this.threeAsTwo = threeAsTwo;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        DecimalFormat dF = new DecimalFormat("0.00");
        if (this.threeAsTwo) {
            return name + " " + dF.format(price) + " руб./шт. (Акция 3 по цене 2)";
        } else {
            return name + " " + dF.format(price) + " руб./шт.";
        }
    }

    public double totalPrice(int qty) {

        if(this.threeAsTwo) { //если это товар по акции 3 по цене 2, то:

            int whole = qty / 3; //это целое от деления на 3
            int tail = qty - whole * 3; // это остаток от деления на 3
            return whole * 2 * this.getPrice() + tail * this.getPrice(); // тогда вычисляем общую цену по этой формуле

        } else {              //а если это не акционный товар:

            return qty * this.getPrice();  //то просто умножаем кол-во товара на его цену

        }
    }
}
