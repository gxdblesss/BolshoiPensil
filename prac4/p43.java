package prac4;

/*Создать абстрактный класс, описывающий сущность мебель. С
помощью наследования реализовать различные виды мебели. Также создать
        класс FurnitureShop, моделирующий магазин мебели. Протестировать работу
классов.*/
import java.util.ArrayList;
import java.util.List;


abstract class Furniture {
    protected String material;  // Материал мебели
    protected double price;     // Цена мебели

    // Конструктор
    public Furniture(String material, double price) {
        this.material = material;
        this.price = price;
    }

    // Абстрактный метод для описания мебели
    public abstract void describe();

    // Геттеры
    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }
}

class Chair extends Furniture {
    private boolean hasArmrest; // Наличие подлокотников

    public Chair(String material, double price, boolean hasArmrest) {
        super(material, price);
        this.hasArmrest = hasArmrest;
    }

    @Override
    public void describe() {
        String armrestInfo = hasArmrest ? "с подлокотниками" : "без подлокотников";
        System.out.println("Стул, материал: " + material + ", цена: " + price + " руб., " + armrestInfo);
    }
}

class Table extends Furniture {
    private int size; // Размер стола (в см)

    public Table(String material, double price, int size) {
        super(material, price);
        this.size = size;
    }

    @Override
    public void describe() {
        System.out.println("Стол, материал: " + material + ", цена: " + price + " руб., размер: " + size + " см.");
    }
}


class Sofa extends Furniture {
    private int numberOfSeats; // Количество мест

    public Sofa(String material, double price, int numberOfSeats) {
        super(material, price);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void describe() {
        System.out.println("Диван, материал: " + material + ", цена: " + price + " руб., количество мест: " + numberOfSeats);
    }
}

// Класс FurnitureShop (Магазин мебели)
class FurnitureShop {
    private List<Furniture> inventory; // Список мебели в магазине

    public FurnitureShop() {
        this.inventory = new ArrayList<>();
    }

    // Метод для добавления мебели в магазин
    public void addFurniture(Furniture furniture) {
        inventory.add(furniture);
        System.out.println("Добавлена новая мебель: ");
        furniture.describe();
    }

    // Метод для вывода всех предметов мебели в магазине
    public void showInventory() {
        System.out.println("\nАссортимент магазина:");
        for (Furniture furniture : inventory) {
            furniture.describe();
        }
    }
}
public class p43 {
    public static void main(String[] args) {
        // Создание магазина мебели
        FurnitureShop shop = new FurnitureShop();

        // Создание различных предметов мебели
        Chair chair1 = new Chair("Дерево", 5000, true);
        Table table1 = new Table("Металл", 12000, 150);
        Sofa sofa1 = new Sofa("Ткань", 20000, 3);

        // Добавление мебели в магазин
        shop.addFurniture(chair1);
        shop.addFurniture(table1);
        shop.addFurniture(sofa1);

        // Вывод ассортимента магазина
        shop.showInventory();
    }
}