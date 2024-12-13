package prac4;

/*Создать мини приложение - интернет-магазин. Должны быть
        реализованы следующие возможности:
        1) Аутентификация пользователя. Пользователь вводит логин и пароль с
        клавиатуры.
        2) Просмотр списка каталогов товаров.
        3) Просмотр списка товаров определенного каталога.
        4) Выбор товара в корзину.
        5) Покупка товаров, находящихся в корзине*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Перечисление для статусов пользователей
enum UserRole {
    ADMIN("Администратор"),
    USER("Пользователь");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

// Класс для пользователя
class User {
    private String login;
    private String password;
    private UserRole role;

    public User(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public boolean authenticate(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    public UserRole getRole() {
        return role;
    }
}

// Класс для товара
class Product {
    private String name;
    private double price;

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

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

// Класс для категории товаров
class Category {
    private String name;
    private List<Product> products;

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Класс для корзины покупок
class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " добавлен в корзину.");
    }

    public void checkout() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }

        double total = 0;
        System.out.println("Вы покупаете следующие товары:");
        for (Product product : products) {
            System.out.println(product);
            total += product.getPrice();
        }
        System.out.println("Общая стоимость: $" + total);
        products.clear();
        System.out.println("Покупка завершена.");
    }
}

// Основной класс интернет-магазина
public class p41 {
    private static Map<String, User> users = new HashMap<>();
    private static List<Category> categories = new ArrayList<>();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    // Статический блок для инициализации данных
    static {
        // Добавляем пользователей
        users.put("admin", new User("admin", "admin123", UserRole.ADMIN));
        users.put("user", new User("user", "user123", UserRole.USER));

        // Создаем категории и товары
        Category electronics = new Category("Электроника");
        electronics.addProduct(new Product("Смартфон", 999.99));
        electronics.addProduct(new Product("Ноутбук", 1299.99));

        Category clothing = new Category("Одежда");
        clothing.addProduct(new Product("Футболка", 19.99));
        clothing.addProduct(new Product("Джинсы", 49.99));

        categories.add(electronics);
        categories.add(clothing);
    }

    // Метод аутентификации пользователя
    public static User authenticate() {
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        User user = users.get(login);
        if (user != null && user.authenticate(login, password)) {
            System.out.println("Аутентификация успешна.");
            return user;
        } else {
            System.out.println("Неверный логин или пароль.");
            return null;
        }
    }

    // Показать список категорий
    public static void showCategories() {
        System.out.println("Категории товаров:");
        for (int i = 0; i < categories.size(); i++){
             System.out.println("Категории товаров:");}
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
    }

    // Показать товары в выбранной категории
    public static void showProductsInCategory(int categoryIndex) {
        if (categoryIndex < 0 || categoryIndex >= categories.size()) {
            System.out.println("Некорректный индекс категории.");
            return;
        }

        Category category = categories.get(categoryIndex);
        System.out.println("Товары в категории " + category.getName() + ":");
        List<Product> products = category.getProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    // Добавить товар в корзину
    public static void addProductToCart(int categoryIndex, int productIndex) {
        if (categoryIndex < 0 || categoryIndex >= categories.size()) {
            System.out.println("Некорректный индекс категории.");
            return;
        }

        Category category = categories.get(categoryIndex);
        List<Product> products = category.getProducts();

        if (productIndex < 0 || productIndex >= products.size()) {
            System.out.println("Некорректный индекс товара.");
            return;
        }

        Product product = products.get(productIndex);
        cart.addProduct(product);
    }

    public static void main(String[] args) {
        User user = authenticate();
        if (user != null) {
            boolean running = true;
            while (running) {
                showCategories();
                System.out.print("Выберите категорию (или введите 0 для выхода): ");
                int categoryChoice = Integer.parseInt(scanner.nextLine());

                if (categoryChoice == 0) {
                    running = false;
                    continue;
                }

                showProductsInCategory(categoryChoice - 1);

                System.out.print("Выберите товар для добавления в корзину (или введите 0 для возвращения): ");
                int productChoice = Integer.parseInt(scanner.nextLine());

                if (productChoice == 0) {
                    continue;
                }

                addProductToCart(categoryChoice - 1, productChoice - 1);

                System.out.print("Хотите завершить покупку? (да/нет): ");
                String checkoutChoice = scanner.nextLine();
                if (checkoutChoice.equalsIgnoreCase("да")) {
                    cart.checkout();
                }
            }
        }
        scanner.close();
        System.out.println("Спасибо за покупку!");
    }
}