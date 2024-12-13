package prac6;
// Интерфейс Nameable
interface Nameable {
    String getName();
}

// Класс для планеты
class Planet implements Nameable {
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Класс для машины
class Car implements Nameable {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Класс для животного
class Animal implements Nameable {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Основной класс для тестирования
public class p61{
    public static void main(String[] args) {
        // Создание объектов разных классов
        Nameable earth = new Planet("Земля");
        Nameable car = new Car("Toyota");
        Nameable dog = new Animal("Собака");

        // Проверка работы метода getName()
        System.out.println("Планета: " + earth.getName());
        System.out.println("Машина: " + car.getName());
        System.out.println("Животное: " + dog.getName());
    }
}

