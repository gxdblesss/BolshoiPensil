package prac3;

/*Создать мини-Приложение интернет-магазин. В приложении
        рассчитывается стоимость покупки товара, где пользователь может выбрать
        валюту для оплаты товара*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double priceInUSD;

    public Product(String name, double priceInUSD) {
        this.name = name;
        this.priceInUSD = priceInUSD;
    }

    public String getName() {
        return name;
    }

    public double getPriceInUSD() {
        return priceInUSD;
    }

    @Override
    public String toString() {
        return name + " - $" + priceInUSD;
    }
}

// Класс для конвертации валют
class CurrencyConverter {
    // Курсы валют относительно доллара США
    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_RUB = 75.0;

    // Метод для конвертации валюты
    public static double convert(double amountInUSD, String currency) {
        switch (currency.toUpperCase()) {
            case "EUR":
                return amountInUSD * USD_TO_EUR;
            case "RUB":
                return amountInUSD * USD_TO_RUB;
            case "USD":
            default:
                return amountInUSD; // Если выбрана валюта USD, возвращаем исходную сумму
        }
    }

    // Метод для получения символа валюты
    public static String getCurrencySymbol(String currency) {
        switch (currency.toUpperCase()) {
            case "EUR":
                return "€";
            case "RUB":
                return "₽";
            case "USD":
            default:
                return "$";
        }
    }
}

// Основной класс интернет-магазина
public class p35 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Список товаров
        List<Product> products = new ArrayList<>();
        products.add(new Product("Смартфон", 999.99));
        products.add(new Product("Ноутбук", 1299.99));
        products.add(new Product("Наушники", 199.99));

        // Выбор товара
        System.out.println("Добро пожаловать в интернет-магазин!");
        System.out.println("Выберите товар для покупки:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).toString());
        }
        System.out.print("Введите номер товара: ");
        int productChoice = scanner.nextInt();

        if (productChoice < 1 || productChoice > products.size()) {
            System.out.println("Некорректный выбор товара.");
            return;
        }

        Product selectedProduct = products.get(productChoice - 1);
        System.out.println("Вы выбрали: " + selectedProduct.getName());

        // Выбор валюты
        System.out.println("Выберите валюту для оплаты (USD, EUR, RUB): ");
        String currencyChoice = scanner.next().toUpperCase();

        // Поддерживаемые валюты
        if (!currencyChoice.equals("USD") && !currencyChoice.equals("EUR") && !currencyChoice.equals("RUB")) {
            System.out.println("Некорректный выбор валюты.");
            return;
        }

        // Конвертация и расчет стоимости
        double priceInSelectedCurrency = CurrencyConverter.convert(selectedProduct.getPriceInUSD(), currencyChoice);
        String currencySymbol = CurrencyConverter.getCurrencySymbol(currencyChoice);

        // Вывод итоговой стоимости
        System.out.printf("Стоимость товара %s в валюте %s: %.2f %s%n",
                selectedProduct.getName(), currencyChoice, priceInSelectedCurrency, currencySymbol);
    }
}