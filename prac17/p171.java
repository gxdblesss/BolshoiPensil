package prac17;

import java.util.ArrayList;
import java.util.Scanner;

// Класс для описания элемента картотеки (например, студента)
class Person {
    private String name;
    private int age;

    // Метод для считывания атрибутов с консоли
    public void readAttributesFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        this.name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        this.age = scanner.nextInt();
    }

    // Метод для вывода атрибутов на экран
    public void displayAttributes() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }

    // Геттеры и сеттеры для удобства (необязательно)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Контейнерный класс для хранения списка объектов Person
class Group {
    private ArrayList<Person> persons;

    // Конструктор для создания пустого списка
    public Group() {
        persons = new ArrayList<>();
    }

    // Функция добавления элемента в список
    public void addPerson() {
        Person person = new Person();
        person.readAttributesFromConsole();
        persons.add(person);
        System.out.println("Пользователь добавлен.");
    }

    // Функция удаления элемента из списка по индексу
    public void removePerson(int index) {
        if (index >= 0 && index < persons.size()) {
            persons.remove(index);
            System.out.println("Пользователь удален.");
        } else {
            System.out.println("Неверный индекс.");
        }
    }

    // Функция вывода элемента списка по индексу
    public void displayPerson(int index) {
        if (index >= 0 && index < persons.size()) {
            persons.get(index).displayAttributes();
        } else {
            System.out.println("Неверный индекс.");
        }
    }

    // Функция вывода всех элементов списка
    public void displayAllPersons() {
        if (persons.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            for (int i = 0; i < persons.size(); i++) {
                System.out.print(i + ". ");
                persons.get(i).displayAttributes();
            }
        }
    }

    // Функция очистки списка
    public void clearAll() {
        persons.clear();
        System.out.println("Список очищен.");
    }

    // Функция проверки, пуст ли список
    public boolean isEmpty() {
        return persons.isEmpty();
    }
}

// Тестовый класс, содержащий главное меню
public class p171 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Group group = new Group();  // Создаем пустой список

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить элемент");
            System.out.println("2. Удалить элемент");
            System.out.println("3. Показать элемент");
            System.out.println("4. Показать всех");
            System.out.println("5. Очистить список");
            System.out.println("6. Проверить, пуст ли список");
            System.out.println("0. Выйти");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Добавление элемента
                    group.addPerson();
                    break;
                case 2:
                    // Удаление элемента
                    System.out.print("Введите индекс для удаления: ");
                    int indexToRemove = scanner.nextInt();
                    group.removePerson(indexToRemove);
                    break;
                case 3:
                    // Показать элемент
                    System.out.print("Введите индекс для отображения: ");
                    int indexToDisplay = scanner.nextInt();
                    group.displayPerson(indexToDisplay);
                    break;
                case 4:
                    // Показать всех
                    group.displayAllPersons();
                    break;
                case 5:
                    // Очистить список
                    group.clearAll();
                    break;
                case 6:
                    // Проверить, пуст ли список
                    if (group.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        System.out.println("Список не пуст.");
                    }
                    break;
                case 0:
                    // Выход из программы
                    System.out.println("Выход из программы.");
                    return;  // Завершаем выполнение программы
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }
    }
}