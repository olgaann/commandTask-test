import java.util.Arrays;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product("Сметана", 80),
                new Product("Сыр", 180),
                new Product("Курица", 250),
                new Product("Кофе", 320),
                new Product("Хлеб", 49.99),

        };

        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i].toString());
        }

        Scanner scan = new Scanner(System.in);
        int[] bin = new int[products.length]; //это массив корзины покупок для хранения кол-ва купленных товаров
        DecimalFormat dF = new DecimalFormat("0.00");
        int count = 0; //счетчик покупок
        while (true) {
            System.out.println("Введите номер товара и количество через пробел. Для завершения введите `end`");
            String input = scan.nextLine();

            if (input.equals("end") && count == 0) {
                System.out.println("Ваша корзина пуста.");
                break;
            } else if (input.equals("end") && count != 0) {
                System.out.println("Ваша корзина: ");
                double sum = 0;
                for (int i = 0; i < bin.length; i++) {
                    if (bin[i] != 0) {
                        System.out.println(products[i].toString() + " " + bin[i] + " шт. " + dF.format(bin[i] * products[i].getPrice()) + " руб. в сумме");
                    }
                    sum += bin[i] * products[i].getPrice();
                }
                System.out.println("Итого: " + dF.format(sum) + " руб.");
                break;
            }
            String[] purchase = input.split(" "); //расщепляем ввод пользователя на номер продукта и количество продукта

            if (purchase.length != 2) { //если пользователь сделал ввод не из двух частей
                System.out.println("Некорректный ввод. Введите два числа через пробел.");
                continue; //переходим к следующей итерации
            }

            int productNumber;
            int qty;

            try {
                productNumber = (Integer.parseInt(purchase[0])) - 1; //определяем номер продукта (в соотв.с ключом массива products)
                qty = Integer.parseInt(purchase[1]);
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка преобразования значения!");
                continue;
            }

            if (productNumber < 0 || productNumber >= products.length || qty <= 0) {
                if (productNumber < 0 || productNumber >= products.length) {
                    System.out.println("Такого номера товара не существует.");
                }
                if (qty <= 0) {
                    System.out.println("Количество товара должно быть положительным.");
                }
                continue;
            }

            bin[productNumber] += qty;
            count++;

        }
    }
}
